package com.example.shopping.controller;

import com.example.shopping.entity.Category;
import com.example.shopping.service.CategoryService;
import com.example.shopping.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v2/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleCategory(@PathVariable int id) {
        Category category = categoryService.getSingleCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCategory(
            @RequestBody String name) {
        Category category = categoryService.addCategory(name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody String name) {
        Category category = categoryService.updateCategory(id, name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
