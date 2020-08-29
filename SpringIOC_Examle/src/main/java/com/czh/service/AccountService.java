package com.czh.service;

import com.czh.domain.Account3;

import java.util.List;

/**
 * @author zhCoding
 * @Description:账户业务层接口
 * @create 16:25
 */
public interface AccountService {

    List<Account3> findAll();

    Account3 findById(Integer id);

    void saveAccount(Account3 account3);

    void updateAccount(Account3 account3);

    void deleteAcc(Integer id);
}
