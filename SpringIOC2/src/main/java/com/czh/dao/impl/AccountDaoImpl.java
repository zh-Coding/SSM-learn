package com.czh.dao.impl;

import com.czh.dao.AccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author zhCoding
 * @Description:
 * @create 13:19
 */
@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("在accountDao1类中实现保存");
    }
}
