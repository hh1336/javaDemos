package mybatis.utils;

import mybatis.annotations.Select;
import mybatis.cfg.Configuration;
import mybatis.cfg.Mapper;
import mybatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLConfigBuilder {
    public static Configuration loadConfiguration(InputStream config) {
        try {
//            定义封装连接信息的配置对象
            Configuration cfg = new Configuration();

//            获取SAXReader对象
            SAXReader reader = new SAXReader();

            Document document = reader.read(config);

            Element root = document.getRootElement();

            List<Element> propertyElements = root.selectNodes("//property");

            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                if ("driver".equals(name)) {
                    String driver = propertyElement.attributeValue("value");
                    cfg.setDriver(driver);
                }
                if ("url".equals(name)) {
                    String url = propertyElement.attributeValue("value");
                    cfg.setUrl(url);
                }
                if ("username".equals(name)) {
                    String username = propertyElement.attributeValue("value");
                    cfg.setUsername(username);
                }
                if ("password".equals(name)) {
                    String password = propertyElement.attributeValue("value");
                    cfg.setPassword(password);
                }
            }
            List<Element> mapperElements = root.selectNodes("//mappers/mapper");
            for (Element mapperElement : mapperElements) {
                Attribute attribute = mapperElement.attribute("resource");
                if (attribute != null) {
                    System.out.println("使用的是XML");
                    String mapperPath = attribute.getValue();
                    Map<String, Mapper> mappers = loadMapperConfiguration(mapperPath);
                    cfg.setMappers(mappers);
                } else {
                    System.out.println("使用的是注解");
                    String daoClassPath = mapperElement.attributeValue("class");
                    Map<String, Mapper> mappers = loadMapperAnnotation(daoClassPath);
                    cfg.setMappers(mappers);
                }
            }
            return cfg;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Map<String, Mapper> loadMapperAnnotation(String daoClassPath) throws Exception {
        Map<String, Mapper> mappers = new HashMap<String, Mapper>();
        Class daoClass = Class.forName(daoClassPath);
        Method[] methods = daoClass.getMethods();
        for (Method method:methods){
            boolean isAnnotated = method.isAnnotationPresent(Select.class);
            if(isAnnotated){
                Mapper mapper = new Mapper();
                Select selectAnno = method.getAnnotation(Select.class);
                String queryString = selectAnno.value();
                mapper.setQueryString(queryString);
                Type type = method.getGenericReturnType();
                if(type instanceof ParameterizedType){
                    ParameterizedType ptype = (ParameterizedType) type;
                    Type[] types = ptype.getActualTypeArguments();
                    Class domainClass = (Class) types[0];
                    String reslutType = domainClass.getName();
                    mapper.setResultType(reslutType);
                }
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String key = className + "." + methodName;
                mappers.put(key,mapper);
            }
        }
        return mappers;
    }

    private static Map<String, Mapper> loadMapperConfiguration(String mapperPath) throws IOException {
        InputStream in = null;
        try {
            Map<String, Mapper> mappers = new HashMap<String, Mapper>();
            in = Resources.getResourceAsStream(mapperPath);
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            Element root = document.getRootElement();
            String namespace = root.attributeValue("namespace");
            List<Element> selectElements = root.selectNodes("//select");
            for (Element selectElement : selectElements) {
                String id = selectElement.attributeValue("id");
                String reslutType = selectElement.attributeValue("reslutType");
                String queryString = selectElement.getText();
                String key = namespace + "." + id;
                Mapper mapper = new Mapper();
                mapper.setQueryString(queryString);
                mapper.setResultType(reslutType);
                mappers.put(key, mapper);
            }
            return mappers;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                in.close();
            }
        }


    }
}
