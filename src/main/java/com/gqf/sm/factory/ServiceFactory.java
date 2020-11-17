package com.gqf.sm.factory;


import com.gqf.sm.service.AdminService;
import com.gqf.sm.service.impl.AdminServiceImpl;

/**
 * @ClassName ServiceFactory
 * @Description TODO
 * @Author Finger
 * @Date 11/15/2020
 **/
public class ServiceFactory {
    public static AdminService getAdminServiceInstance(){
        return new AdminServiceImpl();
    }
}
