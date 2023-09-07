package com.msdev.order_controller_api.service;

import com.msdev.order_controller_api.DTO.DTONewCategory;
import com.msdev.order_controller_api.DTO.DTOUpdateCategory;
import com.msdev.order_controller_api.entity.Category;
import com.msdev.order_controller_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public ResponseEntity insertCategory(Category category){
        if(category.getId() == null) {
            return ResponseEntity.ok()
                    .body(new DTONewCategory(categoryRepository.save(category), "Category created."));
        }else{
            return ResponseEntity.ok()
                    .body(new DTOUpdateCategory(categoryRepository.save(category),"Category updated"));
        }
    }

    public ResponseEntity<List<Category>> listCategory(){
        List<Category> list = categoryRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    public ResponseEntity deleteCategoryById(@RequestParam String id){
        try {
            categoryRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("category delete");
        }catch (Error error){
            return ResponseEntity.ok().body(error);
        }

    }
}
