package com.czh.service.impl;

import com.czh.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author zhCoding
 * @Description:
 * @create 18:43
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存！账户");
    }

    @Override
    public void deleteAcc(int id) {
        System.out.println("删除！账户 " +id);
    }

    @Override
    public int updateAcc() {
        System.out.println("更新！账户");
        return 0;
    }
}
