package com.doing.travel.dao;

import com.doing.travel.entity.Money;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface MoneyRepo extends JpaRepository<Money, Integer> {
    Money findMoneyById(Integer id);

    @Query(value = "select time from money where date_format(time,'%Y-%m')=?2 AND user_id= ?1 order by time desc", nativeQuery=true)
    Set<Date> getMonies(Integer userId, String date);

    List<Money> findMoneyByTimeAndUserId(Date date, Integer userId);

    @Query(value = "select sum(sum) from money where type = ?2 AND user_id= ?1 AND time=?3",nativeQuery = true)
    Double getSum(Integer userId, Integer type, Date time);

    @Query(value = "select * from money where type = ?2 AND user_id= ?1 AND time=?3",nativeQuery = true)
    List<Money> getMoney(Integer userId, Integer type, Date time);

    @Modifying
    @Transactional
    @Query(value = "update money set sum= ?1 , time=?2 , remark=?3 where id= ?4", nativeQuery = true)
    int updateMoney(Double sum, Date time, String remark, Integer id);

    @Query(value = "select time from money where YEARWEEK(date_format(time,'%Y-%m-%d')) = YEARWEEK(now()) AND user_id= ?1 AND type=?2 order by time asc", nativeQuery=true)
    Set<Date> week(Integer userId, Integer type);

    @Query(value = "SELECT time FROM money WHERE DATE_FORMAT( time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) AND user_id=?1 AND type=?2 order by time asc", nativeQuery=true)
    Set<Date> month(Integer userId, Integer type);
}
