package com.czh.dao;

import com.czh.domain.Account;

/**
 * @author zhCoding
 * @Description:
 * @create 13:34
 */
public interface AccountDao {

    Account findAccByName(String name);

    Account findAccById(Integer id);

    void updateAcc(Account account);

}
