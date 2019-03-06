package com.doing.travel.service;

import com.doing.travel.entity.JoinVO;

import java.util.List;

public interface JoinService {

    List<JoinVO> getJoinList(Integer pid);
    List<JoinVO> getJoinByUserId(Integer userId);

}
