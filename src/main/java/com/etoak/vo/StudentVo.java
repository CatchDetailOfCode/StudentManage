package com.etoak.vo;

import com.etoak.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo extends Student {
    private String savepath;
    private String realname;
    private String uploadtime;
}
