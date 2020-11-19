package com.gqf.sm.dao.impl;

import com.gqf.sm.dao.DepartmentDao;
import com.gqf.sm.entity.Department;
import com.gqf.sm.utils.JdbcUtil;
import com.gqf.sm.utils.ResultEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DepartmentDaoimpl
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/18
 **/
public class DepartmentDaoImpl  implements DepartmentDao {

    @Override
    public int insertDepartment(Department department) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = JdbcUtil.getConnection();
        String sql = "INSERT INTO t_department(department_name,logo) VALUES(?,?)";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        pstmt.setString(1,department.getDepartmentName());
        pstmt.setString(2,department.getLogo());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public List<Department> getALL() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = JdbcUtil.getConnection();
        String sql = "SELECT * FROM t_department";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Department> departmentList  =new ArrayList<>();
        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setDepartmentName(rs.getString("department_name"));
            department.setLogo(rs.getString("logo"));
            departmentList.add(department);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return  departmentList;
    }
}
