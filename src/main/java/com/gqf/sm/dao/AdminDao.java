package com.gqf.sm.dao;


import com.gqf.sm.entity.Admin;

import java.sql.SQLException;

public interface AdminDao {

    Admin findAdminByAccount(String account) throws SQLException;
}
