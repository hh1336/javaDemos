package Demos;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * redis里面的数据格式：
 *  1.string：字符串类型(set,get)
 *  2.hashMap：键值对格式(hset,hget,hgetAll)
 *  3.linkedlist：list类型，支持重复元素(lpush,rpush,lpop,rpop)
 *  4.set：集合类型，但是不允许有重复元素(sadd)
 *  5.sortedset：有序集合，不允许重复元素，元素有顺序(zadd)
 */
public class Demo1 {
    /**
     * 操作字符串
     */
    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","张三");
        jedis.close();
    }

    /**
     * 操作hasmap
     */
    @Test
    public void test2(){
        Jedis jedis = new Jedis("localhost",6379);
        //key为集合名，field为键名，value为值
        jedis.hset("user","name","李四");
        jedis.close();
    }

    /**
     * 操作list
     */
    @Test
    public void test3(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.lpush("mylist","a","b","c");
        //从左边取范围内的元素
        jedis.lrange("mylist",0,-1);
        //左边取一个值
        String mylist = jedis.lpop("mylist");
        jedis.close();
    }

    /**
     * set集合
     */
    @Test
    public void test4(){
        Jedis jedis = new Jedis("localhost",6379);
        //添加元素，存入myset这个set集合中
        jedis.sadd("myset","java","php");
        //获取set集合的内容
        Set<String> myset = jedis.smembers("myset");
        jedis.close();
    }
    /**
     * sortedset
     */
    @Test
    public void test5(){
        Jedis jedis = new Jedis("localhost",6379);
        //score用于排序，member为值
        jedis.zadd("mysortedset",2.5,"猪八戒");
        //取值
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        jedis.close();
    }
}
