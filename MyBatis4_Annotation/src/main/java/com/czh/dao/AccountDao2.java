package com.czh.dao;

import com.czh.domain.Account2;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 19:12
 */
public interface AccountDao2 {

    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(property = "user2",column = "uid",
                    one=@One(select = "com.com.czh.dao.User2Dao.findUser2ById",fetchType = FetchType.EAGER))
    })
    List<Account2> findAll();

    @Select("select * from account where uid = #{uid}")
    List<Account2> findAccount2ByUid(Integer uid);

}
