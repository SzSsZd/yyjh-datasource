package com.group_six.yyjhservice;

import com.group_six.yyjhservice.config.jedis.JedisUtil;
import com.group_six.yyjhservice.dao.user.TUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YyjhServiceApplicationTests {

    @Autowired
    TUserMapper tUserMapper;

    @Test
    public void testMybatis(){
        System.out.println(tUserMapper.selectByPrimaryKey(1));
    }

    @Autowired
    JedisUtil jedisUtil;
    @Test
    public void testJedis(){
        System.out.println(jedisUtil.get("test1"));
    }

}
