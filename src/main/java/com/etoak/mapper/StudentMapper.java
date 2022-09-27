package com.etoak.mapper;

import com.etoak.pojo.Pic;
import com.etoak.pojo.School;
import com.etoak.pojo.Student;
import com.etoak.vo.ExelStu;
import com.etoak.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    public List<Student> queryAllStus(Student student);

    public List<ExelStu> queryAll();

    public Student queryStuById(int id);

    public int deleteById(int id);

    //必须抛出异常 否则无法实现事务
    public int addStu(StudentVo studentVo) throws Exception;

    //必须抛出异常
    public int addPic(Pic pic) throws Exception;

    public int updateStu(Student student);

    public List<School> queryAllSchs();

    public String queryPicById(int stuid);

}
