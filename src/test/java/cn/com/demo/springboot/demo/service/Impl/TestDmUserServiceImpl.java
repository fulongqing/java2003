package cn.com.demo.springboot.demo.service.Impl;

import cn.com.demo.springboot.demo.SpringbootDemoApplication;
import cn.com.demo.springboot.demo.entity.User;
import cn.com.demo.springboot.demo.mapper.UserMapper;
import cn.com.demo.springboot.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class TestDmUserServiceImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testVerify(){
        // 测试数据
        String userCode = "admin";
        String password = "1234567";

        // 期望
        boolean result = true;
        // 获取实际结果
        result = userService.verify(userCode,password);
        // 断言
        Assert.assertTrue(result);
    }
    @Test
    public void testRegister(){
      User user = new User();
      user.setUsercode("Aqing");
      user.setUsername("阿清");
      user.setUserpassword("123");
      user.setGender(1);
      user.setBirthday(new Date(123-5466));
      user.setPhone("13667457895");
      user.setAddress("湖南长沙");
    }
    @Test
    public void testSearchAll(){
        List<User> userList = this.userService.searchAll();
        int size = userList.size();
        boolean bool = size == 4 || size == 5;
        Assert.assertTrue(bool);
    }
}
