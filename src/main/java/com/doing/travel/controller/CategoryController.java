package com.doing.travel.controller;

import com.doing.travel.dao.CategoryRepo;
import com.doing.travel.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/icon")
    public Object getIcon(@RequestParam Integer type){
        return ResponseUtil.ok(categoryRepo.findCategoriesByType(type));
    }
}
