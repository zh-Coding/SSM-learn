package com.czh.dao;

import com.czh.domain.User2;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 17:56
 */
public interface User2Dao {

    @Select("select * from user")
    @Results(id="userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "username",property = "userName"),
            @Result(property = "account2s",column = "id",
                    many = @Many(select = "com.com.czh.dao.AccountDao2.findAccount2ByUid",fetchType = FetchType.LAZY))

    })
    List<User2> findAll();

    @Insert("insert into user values(#{userId},#{userName},#{userBirthday},#{userSex},#{userAddress})")
    void saveUser2(User2 user2);

    @Update("update user set username=#{userName},birthday=#{userBirthday},sex=#{userSex},address=#{userAddress} where id=#{userId}")
    void updateUser2(User2 user2);

    @Delete("delete from user where id=#{id}")
    void deleteUser2ById(int id);

    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User2 findUser2ById(Integer id);
}
