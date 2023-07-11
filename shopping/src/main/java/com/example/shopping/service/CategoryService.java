package com.example.shopping.service;

import com.example.shopping.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getSingleCategory(int id);

    Category addCategory(String name);

    Category updateCategory(int id, String name);

    void deleteCategory(int id);
}
