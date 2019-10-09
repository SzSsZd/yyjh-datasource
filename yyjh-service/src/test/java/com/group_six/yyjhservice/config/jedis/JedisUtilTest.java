//package com.group_six.yyjhservice.config.jedis;
//
//import junit.framework.TestCase;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestComponent;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.Test;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JedisUtilTest extends TestCase {
//    @Autowired
//    JedisUtil jedisUtil;
//    @Autowired
//    private JedisPool jedisPool;
//
//    @Test
//    public void testSet() {
//        for (int i = 0;i < 9;i++){
//            jedisUtil.set("test0"+i,"e"+i,10);
//        }
//    }
//
//    @Test
//    public void testGet() {
//        System.out.println(jedisUtil.get("test1",1));
//    }
//    @Test
//    public void testDel() {
//        jedisUtil.del("test1",1);
//    }
//    @Test
//    public void test(){
//        Jedis jedis = jedisPool.getResource();
//        List<String> dbs = jedisUtil.getDBS();
//        for (int i = 0;i < dbs.size();i++){
//            System.out.println(dbs.get(i));
//        }
//    }
//}