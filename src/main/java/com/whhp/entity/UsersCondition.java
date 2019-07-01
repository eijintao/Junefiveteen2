package com.whhp.entity;

/**
 * ASUS mjt
 * 2019/6/24
 * @author 梅锦涛
 */
public class UsersCondition {
    //分页
    /**页码*/
    private Integer page;
    /**页大小*/
    private Integer rows;

    //条件
    /**电话*/
    private String telephone;
    /**开始年龄*/
    private Integer starAge;
    /**结束年龄*/
    private Integer endAge;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getStarAge() {
        return starAge;
    }

    public void setStarAge(Integer starAge) {
        this.starAge = starAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }
}
