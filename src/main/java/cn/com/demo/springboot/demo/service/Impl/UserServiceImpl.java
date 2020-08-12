package cn.com.demo.springboot.demo.service.Impl;

import ch.qos.logback.core.db.dialect.PostgreSQLDialect;
import cn.com.demo.springboot.demo.entity.User;
import cn.com.demo.springboot.demo.mapper.UserMapper;
import cn.com.demo.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.security.util.Password;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional(readOnly = true)
    public boolean verify(String userCode, String password) {
        boolean result = false;
        //根据用户名找用户对象
        User user = userMapper.selectByUserCode(userCode);
        //如果为null->>抛异常
        if (user == null){
            throw new RuntimeException(userCode+"不存在!");
        }else{
            result = user.getUserpassword().equals(password);
        }
        //不为null->> 比较密码
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void register(User user) {
        this.userMapper.insert(user);

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> searchAll() {
        return this.userMapper.selectByExample(null);
    }
}
