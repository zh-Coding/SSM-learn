package com.czh.dao.impl;

import com.czh.dao.AccountDao;

/**
 * @author zhCoding
 * @Description: 持久层实现类
 * @create 20:58
 */
public class AccountDaoImpl implements AccountDao {
    private int i;

    @Override
    public void saveAccount() {
        System.out.println("已保存账户");
        System.out.println(i);
        i++;
    }
}
