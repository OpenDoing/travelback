package com.doing.travel.service.imp;

import com.doing.travel.dao.CategoryRepo;
import com.doing.travel.entity.Category;
import com.doing.travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category mapping(String image) {

        return categoryRepo.findCategoryByCname(image);
    }
}
