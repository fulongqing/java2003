package cn.com.demo.springboot.demo.service;


import cn.com.demo.springboot.demo.entity.User;

import java.util.List;

public interface UserService {
     //匹配密码
    public boolean verify(String userCode,String password);

    //注册
    public  void register(User user);

    //查找所有用户
    public List<User> searchAll();

}
