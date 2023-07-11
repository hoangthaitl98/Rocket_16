package com.example.shopping.service.impl;

import com.example.shopping.entity.Category;
import com.example.shopping.repository.CategoryRepository;
import com.example.shopping.service.CategoryService;
import com.example.shopping.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private StringUtils stringUtils = new StringUtils();
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getSingleCategory(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category.setSlug(stringUtils.createSlug(name));
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int id, String name) {
        Category category = categoryRepository.getById(id);
        category.setName(name);
        category.setSlug(stringUtils.createSlug(name));
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
