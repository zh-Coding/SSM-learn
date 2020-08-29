package com.czh.dao.impl;

import com.czh.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author zhCoding
 * @Description:
 * @create 13:19
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("在accountDao2类中实现保存");
    }
}
