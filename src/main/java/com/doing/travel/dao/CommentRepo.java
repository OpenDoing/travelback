package com.doing.travel.dao;

import com.doing.travel.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentsByPid(Integer pId);
}
