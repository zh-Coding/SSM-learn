package com.czh.DIYMyBatis.Mapper;

/**
 * @author zhCoding
 * @Description:
 * @create 14:05
 */
public class Mapper {
    //查询语句
    private String queryString;
    //查询结果类型，即封装给哪个对象
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public Mapper(String queryString, String resultType) {
        this.queryString = queryString;
        this.resultType = resultType;
    }

    public Mapper() {
    }
}
