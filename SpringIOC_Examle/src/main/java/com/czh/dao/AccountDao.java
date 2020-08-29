package com.czh.dao;

import com.czh.domain.Account3;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 16:34
 */
@Repository
public interface AccountDao {
    @Select("select * from account2")
    List<Account3> findAll();

    @Select("select * from account2 where id=#{id}")
    Account3 findById(Integer id);

    @Insert("insert into account2 values(#{id},#{name},#{money})")
    void saveAccount(Account3 account3);

    @Update("update account2 set name=#{name},money=#{money} where id=#{id}")
    void updateAccount(Account3 account3);

    @Delete("delete from account2 where id=#{id}")
    void deleteAcc(Integer id);
}
