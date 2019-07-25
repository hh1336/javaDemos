package JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {
    private static JedisPool jedisPool;
    static {
        InputStream is = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
        jedisPool = new JedisPool(jedisPoolConfig,prop.getProperty("host"),Integer.parseInt(prop.getProperty("port")));
    }
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
