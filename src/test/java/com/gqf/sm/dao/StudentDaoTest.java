package com.gqf.sm.dao;

import com.gqf.sm.factory.DaoFactory;
import com.gqf.sm.vo.StudentVo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    @Test
    public void selectALll()  throws SQLException {
        List<StudentVo> list  = DaoFactory.getStudentDaoInstance().selectALll();
        list.forEach(System.out::println);
    }
}