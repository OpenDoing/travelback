package com.doing.travel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PlanVO {

    private Integer id;
    private Integer userId;
    private String title;
    private String start;
    private String destination;
    private LocalDateTime ctime;
    private Date stime;
    private Date etime;
    private String cover;
    private String description;
    private String username;
    private String sex;
    private String avatar;
    private Integer budget;
    private Integer people;
    private String fee;

    private List<CommentVO> comments;
    private List<JoinVO> joins;

    public PlanVO(Plan plan){
        this.id = plan.getId();
        this.userId = plan.getUserId();
        this.title = plan.getTitle();
        this.start = plan.getStart();
        this.destination = plan.getDestination();
        this.ctime = plan.getCtime();
        this.stime = plan.getStime();
        this.etime = plan.getEtime();
        this.cover = plan.getCover();
        this.description = plan.getDescription();
        this.budget = plan.getBudget();
        this.people = plan.getPeople();
        this.fee = plan.getFee();
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }

    public List<JoinVO> getJoins() {
        return joins;
    }

    public void setJoins(List<JoinVO> joins) {
        this.joins = joins;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
