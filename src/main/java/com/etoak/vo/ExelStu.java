package com.etoak.vo;

import com.etoak.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExelStu extends Student {
    private int 序号;
    private String 学生姓名;
    private int 学生年龄;
    private String 学生性别;
    private String 学生邮箱;
    private String 学校名称;
    private String 所属城市;

}
