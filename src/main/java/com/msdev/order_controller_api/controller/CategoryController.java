package com.msdev.order_controller_api.controller;

import com.msdev.order_controller_api.entity.Category;
import com.msdev.order_controller_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "new")
    private ResponseEntity insertCategory(@RequestBody Category category){
        return categoryService.insertCategory(category);
    }

    @GetMapping("list")
    private ResponseEntity listAll(){
        return categoryService.listCategory();
    }

    @DeleteMapping(value = "delete", params = "id")
    private ResponseEntity deleteCategory(@RequestParam String id){
        return categoryService.deleteCategoryById(id);
    }
}
