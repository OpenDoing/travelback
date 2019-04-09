package com.doing.travel.service.imp;

import com.doing.travel.dao.MoneyRepo;
import com.doing.travel.entity.Line;
import com.doing.travel.entity.Money;
import com.doing.travel.entity.MoneyVO;
import com.doing.travel.service.CategoryService;
import com.doing.travel.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyRepo moneyRepo;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<MoneyVO> listMoney(Integer userId, String date) {
        Set<Date> monies = moneyRepo.getMonies(userId, date);
        List<MoneyVO> moneyVOS = new ArrayList<>();
        for (Iterator<Date> iterator = monies.iterator();iterator.hasNext();) {
            MoneyVO moneyVO = new MoneyVO();
            Date someday = iterator.next();
            List<Money> somedayMoney = moneyRepo.findMoneyByTimeAndUserId(someday, userId );
            for (Money money: somedayMoney){
                if (money!=null){
                    String path = categoryService.mapping(money.getCategory()).getPath();
                    money.setPath(path);
                }
            }
            moneyVO.setMonies(somedayMoney);
            moneyVO.setDate(someday);
            Double expend = 0.0;
            Double income = 0.0;
            if (moneyRepo.getSum(userId, 0, someday) != null) {
                expend = moneyRepo.getSum(userId, 0, someday);
            }
            if (moneyRepo.getSum(userId, 1, someday) != null) {
                income = moneyRepo.getSum(userId, 1, someday);
            }
            moneyVO.setExpend(expend);
            moneyVO.setIncome(income);
            moneyVOS.add(moneyVO);
        }
        return moneyVOS;
    }

    @Override
    public List<Line> weekData(Integer userId, Integer type) {
        Set<Date> monies = moneyRepo.week(userId, type);
        List<Line> lines = new ArrayList<>();
        for (Iterator<Date> iterator = monies.iterator();iterator.hasNext();) {
            Line line = new Line();
            Date someday = iterator.next();
            line.setDate(someday);
            line.setType(type);
            line.setValue(moneyRepo.getSum(userId, type, someday));
            lines.add(line);
        }
        return lines;
    }

    @Override
    public List<Line> monthData(Integer userId, Integer type) {
        Set<Date> monies = moneyRepo.month(userId, type);
        List<Line> lines = new ArrayList<>();
        for (Iterator<Date> iterator = monies.iterator();iterator.hasNext();) {
            Line line = new Line();
            Date someday = iterator.next();
            line.setDate(someday);
            line.setType(type);
            line.setValue(moneyRepo.getSum(userId, type, someday));
            lines.add(line);
        }
        return lines;
    }
}
