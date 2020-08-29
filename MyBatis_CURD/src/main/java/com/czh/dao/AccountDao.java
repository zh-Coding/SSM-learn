package com.czh.dao;

import com.czh.domain.Account;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 13:19
 */
public interface AccountDao {

    List<Account> findAll();

    Account findAccountByUid(int uid);
}
