package com.doing.travel.service.imp;

import com.doing.travel.dao.UserRepo;
import com.doing.travel.entity.InfoPage;
import com.doing.travel.entity.User;
import com.doing.travel.service.PlanService;
import com.doing.travel.service.UserService;
import com.doing.travel.util.ResponseUtil;
import com.doing.travel.util.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlanService planService;

    @Override
    public InfoPage getInfo(Integer id) {
        InfoPage infoPage = new InfoPage();
        User user = userRepo.findUserById(id);
        infoPage.setId(user.getId());
        infoPage.setSex(user.getSex());
        infoPage.setUsername(user.getUsername());

        int createNum = planService.getPlansByType(user.getId(), 0).size();
        int joinNum = planService.getPlansByType(user.getId(), 1).size();
        infoPage.setCreateNum(createNum);
        infoPage.setJoinNum(joinNum);
        return infoPage;
    }

    @Override
    public String ChangePassword(Integer userId, String opassword, String npassword) {
        User user = userRepo.findUserById(userId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(opassword, user.getPassword())){
            BCryptPasswordEncoder nencoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(npassword));
            userRepo.save(user);
            return "OK";
        } else {
            return "ERROR";
        }
    }
}
