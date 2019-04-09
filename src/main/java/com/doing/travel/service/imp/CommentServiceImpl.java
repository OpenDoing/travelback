package com.doing.travel.service.imp;

import com.doing.travel.dao.CommentRepo;
import com.doing.travel.dao.UserRepo;
import com.doing.travel.entity.Comment;
import com.doing.travel.entity.CommentVO;
import com.doing.travel.entity.User;
import com.doing.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<CommentVO> getCommentsByPid(Integer pid) {
        List<Comment> list = commentRepo.findCommentsByPid(pid);
        List<CommentVO> vlist = new ArrayList<>();
        for (Comment comment: list) {
            CommentVO commentVO = new CommentVO();
            commentVO.setId(comment.getId());
            commentVO.setUserId(comment.getUserId());
            commentVO.setCtime(comment.getCtime());
            commentVO.setContent(comment.getContent());
            User user = userRepo.findUserById(comment.getUserId());
            commentVO.setAvatar(user.getAvatar());
            commentVO.setUsername(user.getUsername());
            vlist.add(commentVO);
        }
        return vlist;
    }

    @Override
    public List<CommentVO> getAllComments() {
        List<Comment> list = commentRepo.findAll();
        List<CommentVO> vlist = new ArrayList<>();
        for (Comment comment: list) {
            CommentVO commentVO = new CommentVO();
            commentVO.setId(comment.getId());
            commentVO.setUserId(comment.getUserId());
            commentVO.setCtime(comment.getCtime());
            commentVO.setContent(comment.getContent());
            User user = userRepo.findUserById(comment.getUserId());
            commentVO.setAvatar(user.getAvatar());
            commentVO.setUsername(user.getUsername());
            vlist.add(commentVO);
        }
        return vlist;
    }
}
