package com.gqf.sm.factory;


import com.gqf.sm.dao.ClazzDao;
import com.gqf.sm.dao.impl.ClazzDaoImpl;
import com.gqf.sm.service.AdminService;
import com.gqf.sm.service.ClazzService;
import com.gqf.sm.service.DepartmentService;
import com.gqf.sm.service.impl.AdminServiceImpl;
import com.gqf.sm.service.impl.ClazzServiceImpl;
import com.gqf.sm.service.impl.DepartmentServiceImpl;

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
     public  static DepartmentService getDepartmentServiceInstance(){
        return  new DepartmentServiceImpl();
     }
    public static ClazzService getClazzServiceInstance(){ return (ClazzService) new ClazzServiceImpl();}

}
