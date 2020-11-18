package com.gqf.sm.service;

import com.gqf.sm.entity.Department;
import com.gqf.sm.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentServiceTest {
    private  final DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll() ;
        departmentList.forEach(System.out::println);
    }
}