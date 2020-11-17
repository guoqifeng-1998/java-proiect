package com.gqf.sm.factory;


import com.gqf.sm.dao.AdminDao;
import com.gqf.sm.dao.impl.AdminDaoImpl;

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
}
