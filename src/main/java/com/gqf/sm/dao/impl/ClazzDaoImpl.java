package com.gqf.sm.dao.impl;

import com.gqf.sm.dao.ClazzDao;
import com.gqf.sm.entity.Clazz;
import com.gqf.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClazzDaoImpl
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/22
 **/
public class ClazzDaoImpl  implements ClazzDao {
    @Override
    public int insertClazz(Clazz clazz) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = JdbcUtil.getConnection();
        String sql = "INSERT INTO t_class(department_id,class_name) VALUES (?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,clazz.getDepartmentId());
        pstmt.setString(2,clazz.getClassName());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public List<Clazz> selectByDepartmentId(int departmentId) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection  = JdbcUtil.getConnection();
        String sql = "SELECT * FROM t_class WHERE department_id = ? ORDER BY id desc";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,departmentId);
        ResultSet rs = pstmt.executeQuery();
        List<Clazz> clazzList = new ArrayList<>();
        while (rs.next()){
            Clazz clazz = new Clazz();
            clazz.setId(rs.getInt(("id")));
            clazz.setDepartmentId(rs.getInt(("department_id")));
            clazz.setClassName(rs.getString(("class_name")));
            clazzList.add(clazz);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return clazzList;
    }

    @Override
    public int deleteClazz(int id) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = JdbcUtil.getConnection();
        String sql = "DELETE FROM t_class WHERE id = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        int n = pstmt.executeUpdate();
        pstmt.close();
        jdbcUtil.closeConnection();
        return  n ;
    }
}
