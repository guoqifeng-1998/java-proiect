package com.gqf.sm.dao;

import com.gqf.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentDao
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/18
 **/
public interface DepartmentDao {
    /**
     * 查询所有院系
     *
     * @return List<Department>
     * @throws SQLException 异常
     */
    List<Department> getALL() throws SQLException;
}
