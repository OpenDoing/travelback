package com.doing.travel.service;

import com.doing.travel.entity.CommentVO;

import java.util.List;

public interface CommentService {

    List<CommentVO> getCommentsByPid(Integer pid);
}
