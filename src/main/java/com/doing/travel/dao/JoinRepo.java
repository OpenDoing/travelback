package com.doing.travel.dao;

import com.doing.travel.entity.Joinp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoinRepo extends JpaRepository<Joinp, Integer> {
    List<Joinp> findJoinsByPid(Integer pid);
    List<Joinp> findJoinsByUserId(Integer userId);
}
