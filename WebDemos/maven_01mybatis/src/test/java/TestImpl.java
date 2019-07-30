import IService.IUser;
import ServiceImp.UserImpl;
import domain.User;
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

public class TestImpl {
    private InputStream is;
    private IUser iUser;

    @Before
    public void init() throws IOException {
        //        读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
//        通过SqlSession类创建接口实现
        iUser = new UserImpl(factory);
    }

    @After
    public void destory() throws IOException {
        if (is != null) {
            is.close();
        }
    }

    @Test
    public void testfindAll() {
        List<User> all = iUser.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setAddress("abcd");
        user.setAge(18);
        user.setName("aaaa");
        iUser.saveUser(user);
        System.out.println(user);
    }

}
