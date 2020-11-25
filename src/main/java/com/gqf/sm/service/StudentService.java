package com.gqf.sm.service;

import com.gqf.sm.entity.Clazz;
import com.gqf.sm.entity.Student;
import com.gqf.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    /**
     * 获取所有学生信息
     * @return List<StudentVo>
     */
    List<StudentVo> getStudentAll();


}
