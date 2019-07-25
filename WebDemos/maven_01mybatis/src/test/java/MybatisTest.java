import IService.IUser;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 简单入门
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
//        读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
//        生产SqlSession类
        SqlSession session = factory.openSession();
//        通过SqlSession类创建接口实现
        IUser iUser = session.getMapper(IUser.class);
//        执行接口方法
        List<User> users = iUser.findAll();
        for (User user : users) {
            System.out.println(user);
        }
//        释放资源
        session.close();
        is.close();
    }
}
