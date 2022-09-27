package com.etoak.mapper;

import com.etoak.pojo.School;
import com.etoak.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper mapper;

   @Test
   void queryAllStus(){
       Student student = new Student();
       student.setSchid(1);
       List<Student> students = mapper.queryAllStus(student);
       for(Student s:students){
           System.out.println(s);
       }
   }

    @Test
    void queryStuById(){
        System.out.println(mapper.queryStuById(1));
    }

    @Test
    void deleteById(){
        System.out.println(mapper.deleteById(68));
    }

//    @Test
//    void addStu(){
//        Student student = new Student();
//        student.setName("伊泽瑞尔");
//        student.setAge(20);
//        student.setEmail("ez@qq.com");
//        student.setSex("男");
//        student.setSchid(1);
//        System.out.println(mapper.addStu(student));
//    }

    @Test
    void updateStu(){
        Student student = new Student();
        student.setName("ez");
        student.setAge(20);
        student.setEmail("ez@qq.com");
        student.setSex("男");
        student.setSchid(1);
        student.setId(33);
        System.out.println(mapper.updateStu(student));
    }

    @Test
    void qeuryAllSchs(){
        System.out.println(mapper.queryAllSchs());
    }


    @Test
    void queryPicById(){
        System.out.println(mapper.queryPicById(55));
    }

}
