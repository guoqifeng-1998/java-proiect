package com.gqf.sm.service.impl;

import com.gqf.sm.dao.ClazzDao;
import com.gqf.sm.entity.Clazz;
import com.gqf.sm.factory.DaoFactory;
import com.gqf.sm.service.ClazzService;
import com.gqf.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/23
 **/
public class ClazzServiceImpl  implements ClazzService {
private  final  ClazzDao clazzDao = DaoFactory.getClazzDaoInstance();

    @Override
    public int addClazz(Clazz clazz) {
        int n = 0;
        try {
            n = DaoFactory.getClazzDaoInstance().insertClazz(clazz);
        } catch (SQLException throwables) {
           System.err.println("新增班级出现异常");
        }
        return n;
    }

    @Override
    public List<Clazz> getClazzByDepId(int departmentId) {
        List<Clazz> clazzList = null;

        try {
            clazzList = clazzDao.selectByDepartmentId(departmentId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
return clazzList;
    }

    @Override
    public int deleteClazz(int id) {
        int n = 0;
        try {
            n = DaoFactory.getClazzDaoInstance().deleteClazz(id);
        } catch (SQLException e ){
            System.err.println("插入班级出现异常");
        }
        return n;
    }
}
