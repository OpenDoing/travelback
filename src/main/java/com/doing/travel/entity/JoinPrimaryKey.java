package com.doing.travel.entity;

import java.io.Serializable;

public class JoinPrimaryKey implements Serializable {

    private Integer pid;

    private Integer userId;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
