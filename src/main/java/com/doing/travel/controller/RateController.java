package com.doing.travel.controller;

import com.doing.travel.dao.RateRepo;
import com.doing.travel.entity.Money;
import com.doing.travel.entity.Rate;
import com.doing.travel.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/rate")
public class RateController {

    @Value("${imgpath}")
    private String filePath;

    @Autowired
    private RateRepo rateRepo;

    @PostMapping("/change")
    public Object change(@RequestParam Double ratem, @RequestParam Integer id) {
        return ResponseUtil.ok(rateRepo.updateRate(ratem, id));
    }

    @PostMapping("/add")
    public Object Add(@RequestBody Rate rate) {
        rateRepo.save(rate);
        return ResponseUtil.ok();
    }

    @GetMapping("/list")
    public Object list() {
        return ResponseUtil.ok(rateRepo.findAll());
    }

    @PostMapping(value = "/flag")
    public Object fileUpload(@RequestParam(value = "file") MultipartFile file) {
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

        return ResponseUtil.ok("上传成功",dest.getName());
    }
}
