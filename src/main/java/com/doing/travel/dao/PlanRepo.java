package com.doing.travel.dao;

import com.doing.travel.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer>{
    List<Plan> findPlansByDestination(String destination);
    List<Plan> findPlansByUserId(Integer userId);
    Plan findPlanById(Integer id);

}
