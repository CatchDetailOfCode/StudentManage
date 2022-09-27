package com.etoak.service;

import com.etoak.pojo.School;
import com.etoak.pojo.Student;
import com.etoak.vo.StudentVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IStudentService {

    //根据id删除
    public int deleteById(int id);

    //更新用户
    public int updateStu(Student student);

    //增加用户
    public int addStuAndPic(StudentVo studentVo) throws Exception;

    //查询用户 并返回查询和分页的结果
    public PageInfo queryStus(int current,int pageSize,Student student);

    //返回导出Exel需要格式的查询
    public List<List<String>> queryAll();

    //查询全部学校
    public List<School> queryAllSchs();

    //根据学生id查询图片的地址
    public String queryPicById(int stuid);
}
