package com.yujian.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Student {
    private int stuId;
    private String stuName;
    private int stuSex;
    private Date stuBirth;
    private ClassInfo classInfo;
}
