package com.czh.service;

import com.czh.domain.Account;

/**
 * @author zhCoding
 * @Description: 账户业务层接口，一般在业务层处理事务
 * @create 13:30
 */
public interface AccountService {

    Account findAccById(Integer id);

    void transfer(String sourceName,String targetName,Float money);

}
