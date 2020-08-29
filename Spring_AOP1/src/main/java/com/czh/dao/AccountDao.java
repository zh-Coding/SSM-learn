package com.czh.dao;

import com.czh.domain.Account3;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 16:34
 */
public interface AccountDao {
    List<Account3> findAll();

    Account3 findById(Integer id);

    void saveAccount(Account3 account3);

    void updateAccount(Account3 account3);

    void deleteAcc(Integer id);

    Account3 findAccByName(String name);
}
