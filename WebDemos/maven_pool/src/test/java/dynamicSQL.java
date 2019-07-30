import IService.IUser;
import domain.QueryVo;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class dynamicSQL {
    private InputStream is;
    private SqlSession session;
    private IUser iUser;
    @Before
    public void init() throws IOException {
        //        读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
//        生产SqlSession类
        session = factory.openSession();
//        通过SqlSession类创建接口实现
        iUser = session.getMapper(IUser.class);
    }
    @After
    public void destory() throws IOException {
        //提交事务
        session.commit();
        if(session != null){
            session.close();
        }
        if(is != null){
            is.close();
        }
    }

    /**
     * 测试动态sql
     */
    @Test
    public void test1(){
        User user = new User();
        user.setAge(18);
        List<User> users = iUser.findCondition(user);
        for (User u : users){
            System.out.println(u);
        }
    }
    @Test
    public void test2(){
        QueryVo query = new QueryVo();
        query.ages = new ArrayList<Integer>();
        query.ages.add(20);
        query.ages.add(30);
        List<User> users = iUser.findInIed(query);
        for (User user : users){
            System.out.println(user);
        }
    }
}
