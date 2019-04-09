package com.doing.travel.dao;

import com.doing.travel.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface RateRepo extends JpaRepository<Rate,Integer> {

    @Modifying
    @Transactional
    @Query(value = "update rate set ratem= ?1 where id= ?2", nativeQuery = true)
    int updateRate(Double ratem, Integer id);
}
