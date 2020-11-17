package com.gqf.sm.dao.impl;


import com.gqf.sm.dao.AdminDao;
import com.gqf.sm.entity.Admin;
import com.gqf.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName AdminDaoImpl
 * @Description TODO
 * @Author Finger
 * @Date 11/15/2020
 **/
public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin findAdminByAccount(String account) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_admin WHERE account = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,account);
        ResultSet resultSet = preparedStatement.executeQuery();
        Admin admin = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String adminAccount = resultSet.getString("account");
            String password = resultSet.getString("password");
            String adminName = resultSet.getString("admin_name");
            admin = new Admin();
            admin.setId(id);
            admin.setAccount(adminAccount);
            admin.setPassword(password);
            admin.setAdminName(adminName);
        }
        resultSet.close();
        preparedStatement.close();
        jdbcUtil.closeConnection();
        return admin;
    }
}
