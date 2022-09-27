package com.etoak.service;

import com.etoak.mapper.StudentMapper;
import com.etoak.pojo.Pic;
import com.etoak.pojo.School;
import com.etoak.pojo.Student;
import com.etoak.vo.ExelStu;
import com.etoak.vo.StudentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private StudentMapper mapper;

    @Override
    public int deleteById(int id) {
         return mapper.deleteById(id);
    }

    @Override
    public int updateStu(Student student) {
        return mapper.updateStu(student);
    }

    @Override
    @Transactional
    public int addStuAndPic(StudentVo studentVo) throws Exception {
        mapper.addStu(studentVo);
        int key = studentVo.getId();
        Pic pic = new Pic();
        pic.setStuid(key);
        pic.setSavepath(studentVo.getSavepath());
        pic.setUploadtime(Timestamp.valueOf(studentVo.getUploadtime()));
        pic.setRealname(studentVo.getRealname());
        int i = mapper.addPic(pic);
        return i;
    }



    @Override
    public PageInfo queryStus(int current, int pageSize, Student student) {
        PageHelper.startPage(current,pageSize);
        List<Student> students = mapper.queryAllStus(student);
        PageInfo pageInfo = new PageInfo(students);
        return pageInfo;
    }

    @Override
    public List<List<String>> queryAll() {
        List<List<String>> result = new ArrayList<>();
        List<ExelStu> students = mapper.queryAll();
        //用于添加表头数据
        ExelStu exelStu = students.get(0);
        Field[] f = exelStu.getClass().getDeclaredFields();
        List<String> l = new ArrayList<>();
        for(Field field:f){
            field.setAccessible(true);
            l.add(field.getName());
        }
        result.add(l);
        //用于添加表内数据
        for(ExelStu s:students){
            List<String> list = new ArrayList<>();
            //遍历一个对象的所有值
            try {
                Field[] fields = s.getClass().getDeclaredFields();
                for(Field field:fields){
                    //设置允许通过反射访问私有变量
                    field.setAccessible(true);
                    list.add(field.get(s).toString());
                }
                result.add(list);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<School> queryAllSchs() {
        List<School> schools = mapper.queryAllSchs();
        return schools;
    }

    @Override
    public String queryPicById(int stuid) {
        String s = mapper.queryPicById(stuid);
        return s;
    }
}
