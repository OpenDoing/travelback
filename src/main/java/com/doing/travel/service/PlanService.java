package com.doing.travel.service;

import com.doing.travel.entity.Plan;
import com.doing.travel.entity.PlanVO;

import java.util.List;

public interface PlanService {
    List<PlanVO> Planlist();
    List<PlanVO> PlanlistByDestination(String destination);
    //0-->create   1--->join
    List<Plan> getPlansByType(Integer userId, Integer type);
    PlanVO getPlanDetail(Integer pid);
}
