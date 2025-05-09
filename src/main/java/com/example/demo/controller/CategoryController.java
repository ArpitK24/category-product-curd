package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // GET all categories with pagination
    @GetMapping
    public ResponseEntity<Page<Category>> getAllCategories(Pageable pageable) {
        Page<Category> categories = categoryService.getAllCategories(pageable);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // POST create a new category
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // GET category by id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Category category = categoryService.getCategoryById(id);
        return category != null 
            ? new ResponseEntity<>(category, HttpStatus.OK) 
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT update category by id
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return updatedCategory != null 
            ? new ResponseEntity<>(updatedCategory, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
