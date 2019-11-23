package cn.edu.aynu.dao;

import cn.edu.aynu.beans.Student;
import org.springframework.stereotype.Repository;


public interface InsertUserMapper {
    void insertUser(Student student);
}
