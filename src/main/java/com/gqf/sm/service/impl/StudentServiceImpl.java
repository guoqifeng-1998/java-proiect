package com.gqf.sm.service.impl;

import com.gqf.sm.dao.StudentDao;
import com.gqf.sm.factory.DaoFactory;
import com.gqf.sm.service.StudentService;
import com.gqf.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/24
 **/
public class StudentServiceImpl  implements StudentService {
    private final StudentDao studentDao = DaoFactory.getStudentDaoInstance();

    @Override
    public List<StudentVo> getStudentAll() {
        List<StudentVo> studentVoList = null;
        try {
            studentVoList = studentDao.selectALll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentVoList;
    }
}
