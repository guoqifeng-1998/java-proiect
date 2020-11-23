package com.gqf.sm.service;

import com.gqf.sm.entity.Clazz;
import com.gqf.sm.factory.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzServiceTest {


    @Test
    public void getClazzByDepId() throws Exception {
        List<Clazz> list = ServiceFactory.getClazzServiceInstance().getClazzByDepId(5);
        list.forEach(System.out::println);
    }
}