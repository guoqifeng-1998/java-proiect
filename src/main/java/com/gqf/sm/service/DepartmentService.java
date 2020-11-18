package com.gqf.sm.service;

import com.gqf.sm.entity.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 查询所有院系
     * @return List<Department>
     */
    List<Department> selectAll();
}
