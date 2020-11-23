package com.gqf.sm.service;

import com.gqf.sm.entity.Clazz;
import com.gqf.sm.factory.ServiceFactory;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
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

    @Test
    public void addClazz() {
        int n = 0;
        Clazz clazz = Clazz.builder()
                .departmentId(5)
                .className("软件一班")
                .build();
        n = ServiceFactory.getClazzServiceInstance().addClazz(clazz);
        assertEquals(1, n);
    }

    @Test
    public void deleteClazz() {
    int n = 0;
    try {
        n = ServiceFactory.getClazzServiceInstance().deleteClazz(1);
    } catch (Exception e){
        e.printStackTrace();
    }
    assertEquals(1,n);
    }

}
