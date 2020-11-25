package com.gqf.sm.dao;

import com.gqf.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    /**
     * 查询所有学生
     *
     * @return 学生视图列表数据
     * @throws java.sql.SQLException 异常
     */
    List<StudentVo> selectALll() throws SQLException;
}
