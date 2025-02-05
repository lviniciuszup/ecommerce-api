package com.zup.ecommerce.controller;

import com.zup.ecommerce.model.Product;
import com.zup.ecommerce.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ServiceController {
    private final ProductService productService;

    public ServiceController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/client")
    public ResponseEntity<Product> newProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(201).body(savedProduct);
    }
    @GetMapping("/products")
    public List<Product> listProducts(){
        return productService.listAllProducts();
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProductbyId(@PathVariable Long id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
}
