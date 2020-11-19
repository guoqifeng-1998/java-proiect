package com.gqf.sm.dao;

import com.gqf.sm.entity.Department;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.reflect.CallerSensitive;

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
     * @param  depaetment 入参
     * @return int
     * @throws SQLException 异常
     */
    int insertDepartment(Department department) throws  SQLException;

                /**
     * 查询所有院系
     *
     * @return List<Department>
     * @throws SQLException 异常
     */
    List<Department> getALL() throws SQLException;
}
