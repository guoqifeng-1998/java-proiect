package com.gqf.sm.service;

import com.gqf.sm.entity.Department;

import java.util.List;

public interface DepartmentService {
    int deleteDepartmentById(int id);
    /**
     * 新增院系
     *
     * @param  department 入参
     * @return int
     */

    /**
     * 查询所有院系
     * @return List<Department>
     */
    List<Department> selectAll();
    int addDepartment(Department department);
}
