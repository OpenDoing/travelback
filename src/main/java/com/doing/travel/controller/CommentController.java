package com.doing.travel.controller;

import com.doing.travel.dao.CommentRepo;
import com.doing.travel.entity.Comment;
import com.doing.travel.service.CommentService;
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

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Object addComment(@RequestBody Comment comment) {
        LocalDateTime now =LocalDateTime.now();
        comment.setCtime(now);
        return ResponseUtil.ok(commentRepo.save(comment));
    }

    @GetMapping("/list")
    public Object getAll() {
        return ResponseUtil.ok(commentService.getAllComments());
    }

    @DeleteMapping("/del")
    private Object Del(@RequestParam Integer id){
        commentRepo.deleteById(id);
        return ResponseUtil.ok("删除成功！");
    }

    @GetMapping("/get")
    public Object getOne(@RequestParam Integer id) {
        return ResponseUtil.ok(commentRepo.findById(id));
    }

    @PostMapping("/change")
    public Object changeComment(@RequestParam Integer id, @RequestParam String content) {
        return ResponseUtil.ok(commentRepo.updateComment(id, content));
    }


}
