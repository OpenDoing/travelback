package com.doing.travel.service;

import com.doing.travel.entity.Line;
import com.doing.travel.entity.Money;
import com.doing.travel.entity.MoneyVO;

import java.util.Date;
import java.util.List;

public interface MoneyService {

    List<MoneyVO> listMoney(Integer userId, String date);
    List<Line> weekData(Integer userId, Integer type);
    List<Line> monthData(Integer userId, Integer type);

}
