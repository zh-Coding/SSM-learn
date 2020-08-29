package com.czh.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 17:55
 */
public class User2 implements Serializable {
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userSex;
    private String userAddress;

    //一对多关系映射  一个用户有多个表
    private List<Account2> account2s;

    public List<Account2> getAccount2s() {
        return account2s;
    }

    public void setAccount2s(List<Account2> account2s) {
        this.account2s = account2s;
    }

    public User2() {
    }

    public User2(Integer userId, String userName, Date userBirthday, String userSex, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userBirthday = userBirthday;
        this.userSex = userSex;
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User2{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userBirthday=" + userBirthday +
                ", userSex='" + userSex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
