package com.msdev.order_controller_api.service;



import com.msdev.order_controller_api.DTO.DTONewCategory;
import com.msdev.order_controller_api.DTO.DTOUpdateCategory;
import com.msdev.order_controller_api.customException.CategoryNotExistException;
import com.msdev.order_controller_api.entity.Category;
import com.msdev.order_controller_api.entity.Product;
import com.msdev.order_controller_api.repository.CategoryRepository;
import com.msdev.order_controller_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;


    public  ResponseEntity insertProduct(Product product){
        Optional<Category> findCategory = categoryRepository.findById(product.getCategory().getId());
        if(findCategory.isEmpty()){
            throw new CategoryNotExistException();
        }
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
