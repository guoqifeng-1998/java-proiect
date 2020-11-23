package com.gqf.sm.dao;

import com.gqf.sm.entity.Clazz;
import com.gqf.sm.factory.DaoFactory;
import com.gqf.sm.factory.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzDaoTest {
    private final ClazzDao clazzDao = DaoFactory.getClazzDaoInstance();

    @Test
    public void selectByDepartmentId() {
        List<Clazz> clazzList = null;
        try {
            clazzList  =  clazzDao.selectByDepartmentId(5);
        } catch ( SQLException throwables){
            throwables.printStackTrace();
        }
        System.out.println(clazzList);
    }
    @Test
  public  void  insertClazz(){
       int n = 0;
       Clazz clazz = Clazz.builder()
               .departmentId(8)
               .className("交通二班")
               .build();
        System.out.println(clazz);
       try {
       n = clazzDao.insertClazz(clazz);
        } catch (SQLException e) {
           e.printStackTrace();
       }
       assertEquals(1,n);
    }
    @Test
     public void deleteClazz(){
        int n = 0;
    try {
       n = clazzDao.deleteClazz(7);
    }catch (SQLException e){
       e.printStackTrace();
   }
        assertEquals(1,n);
    }
}