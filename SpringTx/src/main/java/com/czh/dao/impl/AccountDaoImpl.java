package com.czh.dao.impl;

import com.czh.dao.AccountDao;
import com.czh.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 13:35
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jt;

    @Override
    public Account findAccByName(String name) {
        List<Account> query = jt.query("select * from account2 where name=?", new BeanPropertyRowMapper<>(Account.class), name);
        return query.size()==1 ? query.get(0):null;
    }

    @Override
    public Account findAccById(Integer id) {
        List<Account> query = jt.query("select * from account2 where id=?", new BeanPropertyRowMapper<>(Account.class), id);
        return query.size()==1 ? query.get(0):null;
    }

    @Override
    public void updateAcc(Account account) {
        jt.update("update account2 set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
