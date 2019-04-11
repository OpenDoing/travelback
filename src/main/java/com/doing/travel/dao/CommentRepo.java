package com.doing.travel.dao;

import com.doing.travel.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentsByPid(Integer pId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE comment SET content=?2 WHERE id=?1", nativeQuery = true)
    int updateComment(Integer id, String content);
}
