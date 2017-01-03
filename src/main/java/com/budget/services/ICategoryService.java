package com.budget.services;

import com.budget.dao.entities.Category;

import java.util.List;

/**
 * Created by home on 12.12.16.
 */
public interface ICategoryService {
    Category getCategoryByid(long id);

    List<Category> getAllCategories();
}
