package com.doing.travel.dao;

import com.doing.travel.entity.Money;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MoneyRepo extends JpaRepository<Money, Integer> {
    Money findMoneyById(Integer id);

    @Query(value = "select * from money where date_format(time,'%Y-%m')=?2 AND user_id= ?1", nativeQuery=true)
    List<Money> getMonies(Integer userId, String date);
}
