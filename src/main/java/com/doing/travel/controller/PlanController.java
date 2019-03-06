package com.doing.travel.controller;

import com.doing.travel.dao.PlanRepo;
import com.doing.travel.entity.Plan;
import com.doing.travel.entity.PlanVO;
import com.doing.travel.service.CommentService;
import com.doing.travel.service.JoinService;
import com.doing.travel.service.PlanService;
import com.doing.travel.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/plan")
public class PlanController {

    @Value("${imgpath}")
    private String filePath;

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private PlanService planService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private JoinService joinService;

    @PostMapping("/add")
    private Object AddPlan(@RequestBody Plan plan){
        LocalDateTime now = LocalDateTime.now();
        plan.setCtime(now);
        Calendar cS = Calendar.getInstance();
        cS.setTime(plan.getStime());
        cS.add(Calendar.DAY_OF_MONTH, 1);
        plan.setStime(cS.getTime());

        Calendar cE = Calendar.getInstance();
        cE.setTime(plan.getEtime());
        cE.add(Calendar.DAY_OF_MONTH, 1);
        plan.setEtime(cE.getTime());

        planRepo.save(plan);
        return ResponseUtil.ok(plan);
    }

    @DeleteMapping("/del")
    private Object Del(@RequestParam Integer id){
        planRepo.deleteById(id);
        return ResponseUtil.ok("删除成功！");
    }

    @GetMapping("/list")
    private List<PlanVO> all(@RequestParam Integer id){

        return planService.Planlist();
    }

    @GetMapping("/type")
    private Object createAll(@RequestParam Integer userId, @RequestParam Integer type){
        List<Plan> list = planService.getPlansByType(userId, type);
        return ResponseUtil.ok(list);
    }

    @PostMapping(value = "/cover")
    public Object fileUpload(@RequestParam(value = "file") MultipartFile file,@RequestParam Integer userId) {
        if (file.isEmpty()) {
            return ResponseUtil.fail(404, "文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.fail(-1,"上传失败");
        }
        System.out.println(dest.getName());
        System.out.println(userId);

        return ResponseUtil.ok("上传成功",dest.getName());
    }

}
