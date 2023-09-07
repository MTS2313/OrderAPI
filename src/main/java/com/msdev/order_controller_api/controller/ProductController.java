package com.msdev.order_controller_api.controller;

import com.msdev.order_controller_api.entity.Category;
import com.msdev.order_controller_api.entity.Product;
import com.msdev.order_controller_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("manager/product/new")
    private ResponseEntity insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }
    @DeleteMapping(value = "manager/product/delete", params = "id")
    private ResponseEntity deleteProduct(@RequestParam UUID id){
        return  productService.deleteProduct(id);
    }
    @GetMapping("list")
    private ResponseEntity listProduct(){
        return  productService.listProduct();
    }
}

