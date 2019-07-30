package ServiceImp;

import IService.IUser;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserImpl implements IUser {
    private SqlSessionFactory factory;

    public UserImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("IService.IUser.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("IService.IUser.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {

    }

    public void deleteUser(int id) {

    }
}
