package com.doing.travel.controller;

import com.doing.travel.dao.UserRepo;
import com.doing.travel.entity.User;
import com.doing.travel.util.JacksonUtil;
import com.doing.travel.util.ResponseUtil;
import com.doing.travel.util.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public Object login(@RequestBody String body){
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResponseUtil.badArgument();
        }
        User user = userRepo.findUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword())){
            return ResponseUtil.fail(403, "账号密码不对");
        }
        return ResponseUtil.ok(user);
    }

    @PostMapping("/register")
    public Object reg(@RequestParam String username,
                      @RequestParam String password,
                      @RequestParam Integer sex,
                      @RequestParam Date birth,
                      @RequestParam String phone) {
        User user = new User();
        user.setAvatar("default.png");
        user.setBirth(birth);
        user.setPhone(phone);
        user.setSex(sex);
        user.setUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        userRepo.save(user);
        return ResponseUtil.ok(user);
    }

}
