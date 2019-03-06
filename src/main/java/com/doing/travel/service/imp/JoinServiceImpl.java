package com.doing.travel.service.imp;

import com.doing.travel.dao.JoinRepo;
import com.doing.travel.dao.UserRepo;
import com.doing.travel.entity.Joinp;
import com.doing.travel.entity.JoinVO;
import com.doing.travel.entity.User;
import com.doing.travel.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinRepo joinRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<JoinVO> getJoinList(Integer pid) {
        List<Joinp> list = joinRepo.findJoinsByPid(pid);
        List<JoinVO> jlist = new ArrayList<>();
        for (Joinp joinp :list){
            JoinVO joinVO = new JoinVO();
            joinVO.setPid(joinp.getPid());
            joinVO.setUserId(joinp.getUserId());
            User user = userRepo.findUserById(joinp.getUserId());
            joinVO.setSex(user.getSex());
            joinVO.setAvatar(user.getAvatar());
            jlist.add(joinVO);
        }
        return jlist;
    }

    @Override
    public List<JoinVO> getJoinByUserId(Integer userId) {
        List<Joinp> list = joinRepo.findJoinsByUserId(userId);
        List<JoinVO> jlist = new ArrayList<>();
        for (Joinp joinp :list){
            JoinVO joinVO = new JoinVO();
            joinVO.setPid(joinp.getPid());
            joinVO.setUserId(joinp.getUserId());
            User user = userRepo.findUserById(joinp.getUserId());
            joinVO.setSex(user.getSex());
            joinVO.setAvatar(user.getAvatar());
            jlist.add(joinVO);
        }
        return jlist;
    }
}
