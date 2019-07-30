package dao;

import domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace(blocking = true)//开启二级缓存
public interface IUserDao {

    @Select("select * from users")
    @Results(id="usermap",value = {//配置实体类别名
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "age",property = "age"),
            @Result(column = "address",property = "address"),
            @Result(column = "name",property = "name"),
    })
    List<User> findAll();

    @Insert("insert into users values(#{name},#{age},#{address})")
    void addUser(User user);

    @Select("select * from users where id = #{uid}")
    @ResultMap("usermap")
    User findOneByUser(int userid);

    @Select("select * from users where name like #{username}")
    List<User> findByUserName(String username);
}
