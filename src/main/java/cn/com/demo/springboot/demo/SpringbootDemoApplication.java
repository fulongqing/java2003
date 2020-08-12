package cn.com.demo.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//实现接口的,动态绑定
@MapperScan(basePackages = "cn.com.demo.springboot.demo.mapper" )
//扫描Service
@ComponentScan(basePackages = {"cn.com.demo.springboot.demo.service.Impl",
                               "cn.com.demo.springboot.demo.controller",
                               "cn.com.demo.springboot.demo.config"} )
//开启事务注解
@EnableTransactionManagement
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
