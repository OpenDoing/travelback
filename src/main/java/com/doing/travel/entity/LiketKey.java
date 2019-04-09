package com.doing.travel.entity;

import java.io.Serializable;

public class LiketKey implements Serializable {

    private Integer userId;

    private String destination;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
