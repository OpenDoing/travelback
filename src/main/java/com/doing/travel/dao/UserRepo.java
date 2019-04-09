package com.doing.travel.dao;

import com.doing.travel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    User findUserById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update user set avatar= ?1 where id= ?2", nativeQuery = true)
    int updateAva(String name, Integer userId);

    @Modifying
    @Transactional
    @Query(value = "update user set status= ?1 where id= ?2", nativeQuery = true)
    int updateStatus(Integer status, Integer userId);

    @Modifying
    @Transactional
    @Query(value = "update user set sex= ?2,birth=?3,phone=?4,address=?5,emotion=?6 where id= ?1", nativeQuery = true)
    int updateInfo(Integer userId, String sex, String birth, String phone, String address, String emotion);
}
