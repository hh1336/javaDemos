import dao.IUserDao;
import domain.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void close() throws IOException {
        session.commit();
        if(session != null){
            session.close();
        }
        if(in != null){
            in.close();
        }
    }

    @Test
    public void TestFindAll(){
        List<User> users = userDao.findAll();
        for (User u : users){
            System.out.println(u);
        }
    }
    @Test
    public void TestAddUser(){
        User user = new User();
        user.setName("testadduser");
        user.setAge(20);
        user.setAddress("testaddress");
        userDao.addUser(user);
    }
}
