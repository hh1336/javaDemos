package IService;

import domain.User;

import java.util.List;

/**
 * 操作用户表接口
 */
public interface IUser {

    /**
     * 查询所有数据
     * @return
     */
    List<User> findAll();
}
