package com.gqf.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @ClassName Clazz
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/22
 **/
 @Builder
 @AllArgsConstructor
 @NoArgsConstructor
public class Clazz {
    private Integer id;
    private Integer departmentId;
    private String className;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public String toString() {
        return className;
    }
}
