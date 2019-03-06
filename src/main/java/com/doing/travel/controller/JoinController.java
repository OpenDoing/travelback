package com.doing.travel.controller;

import com.doing.travel.dao.JoinRepo;
import com.doing.travel.entity.Joinp;
import com.doing.travel.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private JoinRepo joinRepo;

    @PostMapping("/add")
    public Object addJoin(@RequestBody Joinp joinp) {
        return ResponseUtil.ok(joinRepo.save(joinp));
    }
}
