package com.gqf.sm.service;


import com.gqf.sm.utils.ResultEntity;

public interface AdminService {
    ResultEntity adminLogin(String account, String password);
}
