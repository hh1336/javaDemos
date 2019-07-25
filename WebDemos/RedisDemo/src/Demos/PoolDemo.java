package Demos;


import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接池
 */
public class PoolDemo {

    @Test
    public void test1(){
        //创建连接配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大允许连接数
        jedisPoolConfig.setMaxTotal(50);
        //最大空闲连接
        jedisPoolConfig.setMaxIdle(10);

        //可空
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);

        //获取连接对象
        Jedis resource = jedisPool.getResource();

        //归还连接
        resource.close();
    }
}




