package com.doing.travel.service.imp;

import com.doing.travel.dao.PlanRepo;
import com.doing.travel.dao.UserRepo;
import com.doing.travel.entity.*;
import com.doing.travel.service.CommentService;
import com.doing.travel.service.JoinService;
import com.doing.travel.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CommentService commentService;

    @Autowired
    private JoinService joinService;

    @Override
    public List<PlanVO> Planlist() {
        List<Plan> list = planRepo.findAll();
        List<PlanVO> vlist = new ArrayList<>();
        for (Plan plan:list){
            List<CommentVO> clist = commentService.getCommentsByPid(plan.getId());
            List<JoinVO> jlist = joinService.getJoinList(plan.getId());
            Integer uid = plan.getUserId();
            PlanVO planVO = new PlanVO(plan);
            User user = userRepo.findUserById(uid);
            planVO.setUsername(user.getUsername());
            planVO.setSex(user.getSex());
            planVO.setAvatar(user.getAvatar());
            planVO.setComments(clist);
            planVO.setJoins(jlist);
            vlist.add(planVO);
        }
        return vlist;
    }

    @Override
    public List<PlanVO> PlanlistByDestination(String destination) {
        List<Plan> list = planRepo.findPlansByDestination(destination);
        List<PlanVO> vlist = new ArrayList<>();
        for (Plan plan:list){
            List<CommentVO> clist = commentService.getCommentsByPid(plan.getId());
            List<JoinVO> jlist = joinService.getJoinList(plan.getId());
            Integer uid = plan.getUserId();
            PlanVO planVO = new PlanVO(plan);
            User user = userRepo.findUserById(uid);
            planVO.setUsername(user.getUsername());
            planVO.setSex(user.getSex());
            planVO.setAvatar(user.getAvatar());
            planVO.setComments(clist);
            planVO.setJoins(jlist);
            vlist.add(planVO);
        }
        return vlist;
    }

    @Override
    public PlanVO getPlanDetail(Integer pid) {
        List<CommentVO> clist = commentService.getCommentsByPid(pid);
        List<JoinVO> jlist = joinService.getJoinList(pid);
        Plan plan = planRepo.findPlanById(pid);
        PlanVO planVO = new PlanVO(plan);
        User user = userRepo.findUserById(plan.getUserId());
        planVO.setUsername(user.getUsername());
        planVO.setSex(user.getSex());
        planVO.setAvatar(user.getAvatar());
        planVO.setComments(clist);
        planVO.setJoins(jlist);
        return planVO;
    }

    @Override
    public List<Plan> getPlansByType(Integer userId, Integer type) {
        if (type == 0) {
            return planRepo.findPlansByUserId(userId);
        }else {
            List<JoinVO> list = joinService.getJoinByUserId(userId);
            List<Plan> vlist = new ArrayList<>();
            for (JoinVO joinVO: list) {
                Plan plan = planRepo.findPlanById(joinVO.getPid());
                vlist.add(plan);
            }
            return vlist;
        }

    }


}
