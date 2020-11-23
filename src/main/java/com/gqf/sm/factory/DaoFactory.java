package com.gqf.sm.factory;


import com.gqf.sm.dao.AdminDao;
import com.gqf.sm.dao.ClazzDao;
import com.gqf.sm.dao.DepartmentDao;
import com.gqf.sm.dao.impl.AdminDaoImpl;
import com.gqf.sm.dao.impl.ClazzDaoImpl;
import com.gqf.sm.dao.impl.DepartmentDaoImpl;
import com.gqf.sm.entity.Clazz;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author Finger
 * @Date 11/15/2020
 **/
public class DaoFactory {
    public static AdminDao getAdminDaoInstance(){
        return new AdminDaoImpl();
    }

    public static DepartmentDao getDepartmentDaoInstance(){
        return  new DepartmentDaoImpl();
    }
    public static ClazzDao getClazzDaoInstance(){return  new ClazzDaoImpl();
    }
}
