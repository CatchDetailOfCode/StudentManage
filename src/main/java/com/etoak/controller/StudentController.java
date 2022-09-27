package com.etoak.controller;

import com.etoak.pojo.Pic;
import com.etoak.pojo.School;
import com.etoak.pojo.Student;
import com.etoak.service.IStudentService;
import com.etoak.utils.ResponseJson;
import com.etoak.utils.exportExelUtil;
import com.etoak.vo.StudentVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stu")
public class StudentController implements ServletContextAware {

    @Autowired
    private IStudentService service;

    @DeleteMapping("{id}")
    public ResponseJson deleteById(@PathVariable int id){
        int i = service.deleteById(id);
        ResponseJson jr = new ResponseJson();
        if(i>0){
            jr.setCode(200);
            jr.setMsg("删除成功!");
        }else{
            jr.setCode(8888);
            jr.setMsg("删除失败!");
        }
        return jr;
    }

    @PutMapping
    public ResponseJson updateStu(@RequestBody Student student){
        int i = service.updateStu(student);
        ResponseJson jr = new ResponseJson();
        if(i>0){
            jr.setCode(200);
            jr.setMsg("修改成功!");
        }else{
            jr.setCode(8888);
            jr.setMsg("修改失败!");
        }
        return jr;
    }

    @PostMapping
    public ResponseJson addStu(@RequestBody StudentVo studentVo) throws Exception{
        int i = service.addStuAndPic(studentVo);
        ResponseJson jr = new ResponseJson();
        if(i>0){
            jr.setCode(200);
            jr.setMsg("添加成功!");
        }else{
            jr.setCode(8888);
            jr.setMsg("添加失败!");
        }
        return jr;
    }

    @RequestMapping("{current}/{pageSize}")
    public ResponseJson queryStus(@PathVariable int current,@PathVariable int pageSize,@RequestBody Student student){
        PageInfo pageInfo = service.queryStus(current,pageSize,student);
        ResponseJson jr = new ResponseJson();
        jr.setCode(200);
        jr.setData(pageInfo);
        jr.setMsg("查询成功!");
        return jr;
    }

    @RequestMapping("/exportExel")
    public void exportExel(HttpServletResponse response) throws IOException {
        List<List<String>> lists = service.queryAll();
        String SheetName = "学生数据";
        String fileName = "Student.xls";
        exportExelUtil util = new exportExelUtil();
        util.exportExcel(response,lists,SheetName,fileName,15);
    }

    @GetMapping("/queryAllSchs")
    public ResponseJson queryAllSchs(){
        List<School> schools = service.queryAllSchs();
        ResponseJson rj = new ResponseJson();
        rj.setCode(200);
        rj.setData(schools);
        rj.setMsg("查询成功!");
        return rj;
    }

    @RequestMapping("/addPic")
    public ResponseJson addPic(MultipartFile pic) throws IOException{
        //获取到了iamges目录
        String name = pic.getOriginalFilename();
        String flex = name.substring(name.lastIndexOf("."));
        String newName = UUID.randomUUID().toString().replaceAll("-","")+flex;
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "images";
        System.out.println(realPath);
        File p = new File(realPath);

        File target = new File(realPath,newName);
        pic.transferTo(target);
        Pic pic1 = new Pic();
        pic1.setSavepath(newName);
        pic1.setRealname(name);
        pic1.setUploadtime(new Timestamp(System.currentTimeMillis()));
        ResponseJson rj = new ResponseJson();
        rj.setCode(200);
        rj.setData(pic1);
        rj.setMsg("返回图片成功!");
        return rj;
    }
    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @RequestMapping("/queryPicById/{id}")
    public ResponseJson queryPicById(@PathVariable int id){
        String s = service.queryPicById(id);
        ResponseJson rj = new ResponseJson();
        rj.setCode(200);
        rj.setData(s);
        rj.setMsg("返回图片路径成功");
        return rj;
    }
}
