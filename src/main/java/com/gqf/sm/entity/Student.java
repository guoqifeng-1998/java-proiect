package com.gqf.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/24
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private String id;
    private Integer classId;
    private  String studentName;
    private String phone;
    private  short gender;
    private Date birthday;
    private  String avatar;
    private String address;
}
