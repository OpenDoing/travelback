package com.doing.travel.dao;

import com.doing.travel.entity.Liket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LiketRepo extends JpaRepository<Liket,Integer> {

    Liket findLiketByUserIdAndDestination(Integer userId, String destination);
    List<Liket> findLiketsByUserId(Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT  INTO liket(user_id,destination,frequency) VALUES (?1,?2,?3)", nativeQuery = true)
    int insertLike(Integer userId, String destination, Integer frequency);

    @Modifying
    @Transactional
    @Query(value = "UPDATE liket SET user_id=?1,destination=?2,frequency=?3", nativeQuery = true)
    int updateLike(Integer userId, String destination, Integer frequency);
}
