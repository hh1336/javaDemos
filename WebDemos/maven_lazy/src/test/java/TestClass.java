import IService.IUser;
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

public class TestClass {
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
     * 测试保存方法
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setName("六六六");
        user.setAge(30);
        user.setAddress("北京");
        iUser.saveUser(user);
        System.out.println(user);

    }
    /**
     * 测试修改方法
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(9);
        user.setName("abcd");
        user.setAge(20);
        user.setAddress("北京");
        iUser.updateUser(user);
    }

    /**
     * 删除方法
     */
    @Test
    public void testdelete(){
        iUser.deleteUser(9);
    }
}
