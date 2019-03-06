package com.doing.travel.entity;

import javax.persistence.*;

@Entity
@Table(name = "joinp")
@IdClass(JoinPrimaryKey.class)
public class Joinp {
    @Id
    private Integer pid;
    @Column(name = "user_id")
    @Id
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
