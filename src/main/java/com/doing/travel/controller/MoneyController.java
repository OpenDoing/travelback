package com.doing.travel.controller;

import com.doing.travel.dao.MoneyRepo;
import com.doing.travel.entity.Money;
import com.doing.travel.entity.MoneyVO;
import com.doing.travel.service.MoneyService;
import com.doing.travel.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyRepo moneyRepo;

    @Autowired
    private MoneyService moneyService;

    @GetMapping("/list")
    public Object getlist(@RequestParam Integer userId, @RequestParam String date){
        List<MoneyVO> moneyList = moneyService.listMoney(userId, date);
        return ResponseUtil.ok(moneyList);
    }

    @PostMapping("/add")
    public Object addMoney(@RequestBody Money money){
        moneyRepo.save(money);
        return ResponseUtil.ok();
    }

    @GetMapping("/get")
    public Object getMoney(@RequestParam Integer id){
        return ResponseUtil.ok(moneyRepo.findMoneyById(id));
    }

    @DeleteMapping("/del")
    public Object delMoney(@RequestParam Integer id){
        moneyRepo.deleteById(id);
        return ResponseUtil.ok();
    }

    @PostMapping("/edit")
    public Object edit(@RequestBody Money money) {
        return ResponseUtil.ok(moneyRepo.updateMoney(money.getSum(),money.getTime(),money.getRemark(),money.getId()));
    }

    @GetMapping("/week")
    public Object getWeek(@RequestParam Integer userId,@RequestParam Integer type){
        return ResponseUtil.ok(moneyService.weekData(userId, type));
    }

    @GetMapping("/month")
    public Object getMonth(@RequestParam Integer userId,@RequestParam Integer type){
        return ResponseUtil.ok(moneyService.monthData(userId, type));
    }


}
