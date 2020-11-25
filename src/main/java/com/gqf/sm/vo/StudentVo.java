package com.gqf.sm.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName StudentVo
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/24
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentVo {
    private String id;
    private String departmentName;
    private String className;
    private  String studentName;
    private String phone;
    private  short gender;
    private Date birthday;
    private  String avatar;
    private String address;

}
