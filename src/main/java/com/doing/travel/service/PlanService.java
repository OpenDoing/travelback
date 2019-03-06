package com.doing.travel.service;

import com.doing.travel.entity.Plan;
import com.doing.travel.entity.PlanVO;

import java.util.List;

public interface PlanService {
    List<PlanVO> Planlist();
    //0-->create   1--->join
    List<Plan> getPlansByType(Integer userId, Integer type);
}
