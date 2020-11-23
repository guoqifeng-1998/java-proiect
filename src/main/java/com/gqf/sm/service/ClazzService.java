package com.gqf.sm.service;

import com.gqf.sm.entity.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzService
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/22
 **/
public interface ClazzService {
    /**
     * 新增班级
     * @param  clazz 班级实体
     * @return int
     */
    int addClazz(Clazz clazz);
    /**
     * 按照院系id获取班级
     * @param  departmentId 院系id
     * @return 班级信息
     *
     **/
    List<Clazz> getClazzByDepId(int departmentId) ;
    /**
     * 删除班级
     * @param  id 班级id
     * @return int
     */
     int deleteClazz (int id );


}
