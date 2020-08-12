package cn.com.demo.springboot.demo.controller;

import cn.com.demo.springboot.demo.entity.User;
import cn.com.demo.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("myRedisTemplate") //@Resource
    private RedisTemplate<String,Object> redisTemplate;
    //显示登陆页面的请求方法
    @GetMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public  String login(String userCode, String password, Model model, HttpSession session){
        String result="redirect:/userList";
        boolean bool=false;
        String msg=null;
        try {
            bool = this.userService.verify(userCode, password);
            if (!bool) {
                msg = "登录失败:密码不正确";
            }else{
                //在session中保存当前的用户名
                session.setAttribute("userCode",userCode);
                // 往Redis 中添加登录标记
                this.redisTemplate.opsForValue().set(userCode,"hasLogin");
                //有bug
                this.redisTemplate.expire(userCode,1000, TimeUnit.SECONDS);

            }
        }catch(Exception e){
            msg="登录失败:"+e.getMessage();
        }
        if (!bool){
            model.addAttribute("msg",msg);
            result="redirect:/loginPage?id=1";
        }
        return result;
    }

    //注册页面的方法
    @GetMapping("/registePage")
    public String registePage(){
        return "register";
    }

    //处理注册功能的方法
    @PostMapping("/registe")
    public String registe(User user, Model model){
        String result = "redirect:/loginPage";
        String msg = null;
        try {
            this.userService.register(user);
        }catch(Exception e){
            msg = "注册失败:" + e.getMessage();
            model.addAttribute("msg",msg);
            result = "redirect:/registePage";
        }
        return result;
    }

    //显示用户列表的方法
    @GetMapping("/userList")
    public String userList(Model model,HttpSession session){
        String result = "userList";
        //判断是否有登录,如果没有登录,转向到login页面,有登陆,继续跑
        try{
            String userCode = (String) session.getAttribute("userCode");
            Object loginFlg = this.redisTemplate.opsForValue().get(userCode);
            if (loginFlg == null){
                result = "redirect:/loginPage";
            }else{
                List<User> userList = this.userService.searchAll();
                for (User u:userList){
                    System.out.println(u.getUsercode());
                }
               model.addAttribute("userList",userList);
                model.addAttribute("welcome","Welcome......");
            }
        }catch(Exception e){
            e.printStackTrace();
            result = "redirect:/loginPage";
        }
        return result;
    }


}
