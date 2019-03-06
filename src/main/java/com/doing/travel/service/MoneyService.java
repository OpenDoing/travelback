package com.doing.travel.service;

import com.doing.travel.entity.Money;

import java.util.Date;
import java.util.List;

public interface MoneyService {

    List<Money> listMoney(Integer userId, String date);
}
