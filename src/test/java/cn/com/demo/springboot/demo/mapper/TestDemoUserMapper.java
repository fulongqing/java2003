package cn.com.demo.springboot.demo.mapper;

import cn.com.demo.springboot.demo.SpringbootDemoApplication;
import cn.com.demo.springboot.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class TestDemoUserMapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectByUser(){
        //准备测试数据
        int id=1;
        //准备期望值
        // 系统管理员
        // admin
        String userCode="admin";
        String userName="系统管理员";
        //获取实际值
        User user=userMapper.selectByPrimaryKey(1l);
        String acUserCode=user.getUsercode();
        String acUserName=user.getUsername();
        Assert.assertEquals(userCode,acUserCode);
        Assert.assertEquals(userName,acUserName);
        System.out.println(user);


    }
}
