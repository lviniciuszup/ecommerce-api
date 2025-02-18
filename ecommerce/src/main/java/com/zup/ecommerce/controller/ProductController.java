package com.zup.ecommerce.controller;

import com.zup.ecommerce.dto.ProductRequestDTO;
import com.zup.ecommerce.dto.ProductResponseDTO;
import com.zup.ecommerce.model.Product;
import com.zup.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/produtos")
    public ResponseEntity<ProductResponseDTO> newProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productRequestDTO));
    }
    @GetMapping("/api/produtos")
    public List<ProductResponseDTO> listProducts(){
        return productService.listAllProducts();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deleteProductbyId(@PathVariable Long id){
       productService.deleteProduct(id);
       return ResponseEntity.noContent().build();
    }
}
