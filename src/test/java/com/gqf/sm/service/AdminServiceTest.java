package com.gqf.sm.service;

import com.gqf.sm.factory.ServiceFactory;
import com.gqf.sm.utils.ResultEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceTest {
    private  final AdminService adminService = ServiceFactory.getAdminServiceInstance();

    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminService.adminLogin("1138153570@qq.com","guoqifeng1998");
        assertEquals(0,resultEntity.getCode());
        System.out.println(resultEntity);
    }
}