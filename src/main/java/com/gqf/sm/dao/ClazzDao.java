package com.gqf.sm.dao;

import com.gqf.sm.entity.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzDao
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/22
 **/
public interface ClazzDao {
    /**
     * 新增班级
     * @param clazz 入参班级实体
     * @return int
     * @throws SQLException 异常
     */
    int insertClazz(Clazz clazz) throws SQLException;
    /**
     * 按照院系id查询班级
     *
     * @param  departmentId 院系id
     * @return List<CClass>院系班级集合
     * @throws java.sql.SQLException 异常
     */
   List<Clazz> selectByDepartmentId(int departmentId) throws SQLException;
    /**
     * 删除班级
     * @param  id 班级id
     * @return int
     * @throws SQLException 异常
     */
     int deleteClazz(int id) throws SQLException;


}
