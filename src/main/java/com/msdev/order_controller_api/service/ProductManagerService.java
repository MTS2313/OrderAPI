package com.msdev.order_controller_api.service;



import com.msdev.order_controller_api.DTO.DTONewCategory;
import com.msdev.order_controller_api.DTO.DTOUpdateCategory;
import com.msdev.order_controller_api.entity.Category;
import com.msdev.order_controller_api.entity.Product;
import com.msdev.order_controller_api.repository.CategoryRepository;
import com.msdev.order_controller_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ProductManagerService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

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

    public  ResponseEntity insertProduct(Product product){
        return ResponseEntity.ok().body(productRepository.save(product));
    }

    public ResponseEntity deleteProduct(UUID id){
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Product>> listProduct(){
        return ResponseEntity.ok().body(productRepository.findAll());
    }
}
