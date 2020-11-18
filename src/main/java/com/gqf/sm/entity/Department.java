package com.gqf.sm.entity;

import com.sun.scenario.effect.impl.prism.PrImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Department
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    private Integer id;
    private String departmentName;
    private String  logo;
}
