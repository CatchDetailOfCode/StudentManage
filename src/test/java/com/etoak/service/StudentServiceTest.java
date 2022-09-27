package com.etoak.service;

import com.etoak.pojo.School;
import com.etoak.pojo.Student;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private IStudentService service;

    @Test
    void deleteById(){
        System.out.println(service.deleteById(33));;
    }

//    @Test
//    void addStu(){
//        Student student = new Student();
//        student.setName("伊泽瑞尔");
//        student.setAge(20);
//        student.setEmail("ez@qq.com");
//        student.setSex("男");
//        student.setSchid(1);
//        System.out.println(service.addStu(student));
//    }

    @Test
    void updateStu(){
        Student student = new Student();
        student.setName("派克");
        student.setAge(20);
        student.setEmail("ez@qq.com");
        student.setSex("男");
        student.setSchid(1);
        student.setId(34);
        System.out.println(service.updateStu(student));
    }

    @Test
    void queryStus(){
        Student student = new Student();
        student.setName("酒");
        PageInfo pageInfo = service.queryStus(1, 3, student);
        System.out.println(pageInfo);
    }

    @Test
    void GetExelData(){
        List<List<String>> lists = service.queryAll();
        System.out.println(lists);
    }

    @Test
    void queryAllSchs(){
        List<School> schools = service.queryAllSchs();
        System.out.println(schools);
    }
}
