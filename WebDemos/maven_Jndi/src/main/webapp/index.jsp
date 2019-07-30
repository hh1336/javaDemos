<%@ page import="java.io.*" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="IService.IUser" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello word
<%
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建工厂
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(is);
//        生产SqlSession类
    SqlSession sqlsession = factory.openSession();
//        通过SqlSession类创建接口实现
    IUser iUser = sqlsession.getMapper(IUser.class);
//        执行接口方法
    List<User> users = iUser.findAll();
    for (User user : users) {
        System.out.println(user);
    }
//        释放资源
    sqlsession.close();
    is.close();
%>
</body>
</html>
