package com.czh.dao;

import com.czh.domian.User;

import java.util.List;

/**
 * 用户持久层接口
 *
 * @author zhCoding
 * @Description:
 * @create 20:53
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

}
