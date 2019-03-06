package com.doing.travel.controller;

import com.doing.travel.dao.CommentRepo;
import com.doing.travel.entity.Comment;
import com.doing.travel.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    @PostMapping("/add")
    public Object addComment(@RequestBody Comment comment) {
        LocalDateTime now =LocalDateTime.now();
        comment.setCtime(now);
        return ResponseUtil.ok(commentRepo.save(comment));
    }


}
