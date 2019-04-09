package com.doing.travel.entity;

import java.util.Date;
import java.util.List;

public class MoneyVO {
    private Date date;
    private Double expend;
    private Double income;
    private List<Money> monies;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getExpend() {
        return expend;
    }

    public void setExpend(Double expend) {
        this.expend = expend;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public List<Money> getMonies() {
        return monies;
    }

    public void setMonies(List<Money> monies) {
        this.monies = monies;
    }
}
