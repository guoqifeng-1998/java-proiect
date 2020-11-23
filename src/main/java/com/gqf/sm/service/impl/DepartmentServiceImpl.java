package com.gqf.sm.service.impl;

import com.gqf.sm.dao.DepartmentDao;
import com.gqf.sm.entity.Department;
import com.gqf.sm.factory.DaoFactory;
import com.gqf.sm.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentServiceImpl
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/18
 **/
public class DepartmentServiceImpl  implements DepartmentService {
    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    @Override
    public int deleteDepartmentById(int id) {
        int n = 0;
        try {
            n = departmentDao.deleteDepartmentById(id);
        } catch ( SQLException e){
            e.printStackTrace();
        }
        return n;

    }

    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;
        try {
            departmentList =departmentDao.getALL();
        } catch (SQLException e){
            System.err.print("查询院系信息出现异常");
        }
        return departmentList;
    }

    @Override
    public int addDepartment(Department department) {
        int n = 0;
        try {
            n = departmentDao.insertDepartment(department);
        } catch (SQLException e){
            System.err.print("新增院系信息出现异常");
        }
        return n;
    }
}
