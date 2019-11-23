package cn.edu.aynu.service.impl;

import cn.edu.aynu.beans.Student;
import cn.edu.aynu.dao.InsertUserMapper;
import cn.edu.aynu.service.IinsertUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("insertUserService")
public class insertUserServiceImpl implements IinsertUserService {

    @Autowired
    private InsertUserMapper userDao;

    public void setUserDao(InsertUserMapper userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insertUser(Student student) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao = (InsertUserMapper) ac.getBean("insertUserMapper");
        System.out.println("service:"+userDao);
        userDao.insertUser(student);
    }
}
