package com.doing.travel.controller;

import com.doing.travel.dao.MoneyRepo;
import com.doing.travel.entity.Money;
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
        List<Money> moneyList = moneyService.listMoney(userId, date);
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
}
