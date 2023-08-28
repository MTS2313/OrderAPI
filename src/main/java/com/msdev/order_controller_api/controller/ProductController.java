package com.msdev.order_controller_api.controller;

import com.msdev.order_controller_api.entity.Category;
import com.msdev.order_controller_api.entity.Product;
import com.msdev.order_controller_api.service.ProductManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductManagerService productManagerService;
    @PostMapping(value = "manager/category/new")
    private ResponseEntity insertCategory(@RequestBody Category category){
        return productManagerService.insertCategory(category);
    }
    @GetMapping("category/list")
    private ResponseEntity listAll(){
        return productManagerService.listCategory();
    }
    @PostMapping("manager/product/new")
    private ResponseEntity insertProduct(@RequestBody Product product){
        return productManagerService.insertProduct(product);
    }
    @DeleteMapping(value = "manager/product/delete", params = "id")
    private ResponseEntity deleteProduct(@RequestParam UUID id){
        return  productManagerService.deleteProduct(id);
    }
    @GetMapping("product/list")
    private ResponseEntity listProduct(){
        return  productManagerService.listProduct();
    }
}

