package com.etoak.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pic {
    private int id;

    private String savepath;

    private String realname;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss:S")
    private Timestamp uploadtime;

    private int stuid;


}
