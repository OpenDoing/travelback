package com.doing.travel.dao;

import com.doing.travel.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    List<Category> findCategoriesByType(Integer type);
    Category findCategoryByCname(String name);
}
