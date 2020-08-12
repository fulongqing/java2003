package cn.com.demo.springboot.demo.controller;

import cn.com.demo.springboot.demo.SpringbootDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
@AutoConfigureMockMvc // 启用MockMvc
public class TestUserController {
    @Autowired
    private UserController userController;
    @Autowired
    private MockMvc mvc;// 发送和接收web请求的对象（MockMvc）

    @Test
    public void testLoginPage()throws Exception{
        String url = "/loginPage";
        // 封装成一个get请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url);
        // 设置可以接收响应的内容
        builder.accept(MediaType.TEXT_HTML);

        // 用mvc发送请求(行为)
        ResultActions action = mvc.perform(builder);
        // 获取行为的结果
        MvcResult result = action.andReturn();

        // 获取响应
        MockHttpServletResponse response = result.getResponse();
        int status = response.getStatus();
        String content = response.getContentAsString();
        System.out.println(status);
        System.out.println(content);
    }

    @Test
    public void testLogin()throws Exception{

        String url="/login";
        //用post方式提交
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url);
        // 设置enctype
        builder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        //添加提交的数据
        String data="userCode=admin&&password=1234657";
        builder.content(data);
        // 接收的类型
        builder.accept(MediaType.TEXT_HTML);

        ResultActions actions =  mvc.perform(builder);
        MvcResult result = actions.andReturn();
        MockHttpServletResponse response = result.getResponse();
        String location = response.getHeader("Location");
        System.out.println("***" + response.getContentAsString());
        System.out.println(location);
        System.out.println(response.getStatus());

    }
    @Test
    public void testRegistePage(){

    }
    @Test
    public void testRegiste(){

    }
    @Test
    public void testUserList() throws Exception{
        String url = "/userList";
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url);
        builder.accept(MediaType.TEXT_HTML);

        ResultActions action = mvc.perform(builder);
        MvcResult result = action.andReturn();

        MockHttpServletResponse response = result.getResponse();
        System.out.println(response.getContentAsString());

    }
}
