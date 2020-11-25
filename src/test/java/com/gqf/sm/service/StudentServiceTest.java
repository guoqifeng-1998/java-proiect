package com.gqf.sm.service;

import com.gqf.sm.factory.DaoFactory;
import com.gqf.sm.vo.StudentVo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {

    @Test
    public void getStudentAll() {
        List<StudentVo> list = null;
        try {
            list = DaoFactory.getStudentDaoInstance().selectALll();
            list.forEach(System.out::println);
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}