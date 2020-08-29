package com.czh.service.impl;

import com.czh.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author zhCoding
 * @Description:
 * @create 12:55
 */
@Service("accountService3")
public class AccountServiceImpl3 implements AccountService {

    private String[] str;
    private List list;
    private Map map;

    @Override
    public String toString() {
        return "AccountServiceImpl3{" +
                "str=" + Arrays.toString(str) +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    @Override
    public void saveAccount() {
        System.out.println("saveAccount...");
    }
}
