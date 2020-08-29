package com.czh.dao.impl;

import com.czh.dao.AccountDao;
import com.czh.domain.Account3;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 17:36
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account3> findAll() {
        try {
            return queryRunner.query("select * from account2",new BeanListHandler<Account3>(Account3.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account3 findById(Integer id) {

        try {
            return queryRunner.query("select * from account2 where id=?",new BeanHandler<>(Account3.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account3 account3) {
        try {
            queryRunner.update("insert into account2(name,money) values(?,?)",account3.getName(),account3.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account3 account3) {
        try {
            queryRunner.update("update account2 set name=?,money=? where id=?",
                    account3.getName(),account3.getMoney(),account3.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAcc(Integer id) {
        try {
            queryRunner.update("delete from account2 where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
