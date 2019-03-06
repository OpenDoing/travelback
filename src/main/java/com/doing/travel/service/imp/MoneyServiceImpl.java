package com.doing.travel.service.imp;

import com.doing.travel.dao.MoneyRepo;
import com.doing.travel.entity.Money;
import com.doing.travel.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyRepo moneyRepo;

    @Override
    public List<Money> listMoney(Integer userId, String date) {
        List<Money> monies = moneyRepo.getMonies(userId, date);
        return monies;
    }
}
