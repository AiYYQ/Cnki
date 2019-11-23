package cn.edu.aynu.controller;


import cn.edu.aynu.beans.Student;
import cn.edu.aynu.service.impl.insertUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class userController {

    @Resource
    private insertUserServiceImpl userService;

    @RequestMapping("insertUser")
    public String insertUser(Student student){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (insertUserServiceImpl) ac.getBean("insertUserService");
        System.out.println(student);

        userService.insertUser(student);
        return "success";
    }
}
