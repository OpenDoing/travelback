package com.doing.travel.entity;

import javax.persistence.*;

@Entity
@Table(name = "liket")
@IdClass(LiketKey.class)
public class Liket {

    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Id
    private String destination;
    private Integer frequency;

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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
