package com.doing.travel.dao;

import com.doing.travel.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer>{
    List<Plan> findPlansByDestination(String destination);
    List<Plan> findPlansByUserId(Integer userId);
    Plan findPlanById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE plan SET title=?2,start=?3,destination=?4,budget=?5,people=?6, fee=?7,description=?8, stime=?9, etime=?9 WHERE id=?1", nativeQuery = true)
    int updatePlan(Integer id, String title, String start, String destination, Integer budget, Integer people, String fee, String description, String stime, String etime);
}
