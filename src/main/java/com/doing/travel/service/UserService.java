package com.doing.travel.service;

import com.doing.travel.entity.InfoPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService{
    InfoPage getInfo(Integer id);
    String ChangePassword(Integer userId, String opassword, String npassword);
}
