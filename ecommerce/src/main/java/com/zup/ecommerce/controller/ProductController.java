package com.zup.ecommerce.controller;

import com.zup.ecommerce.dto.ProductDTO;
import com.zup.ecommerce.model.Product;
import com.zup.ecommerce.services.ProductService;
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
    public ResponseEntity<Product> newProduct(@RequestBody ProductDTO productDTO){
        //Criamos um novo produto a partir do parametro
        Product product = new Product(productDTO.name(), productDTO.price(), productDTO.quantity());
        // Chamamos o service com o metodo criar produto
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(201).body(savedProduct);
    }
    @GetMapping("/produtos")
    public List<Product> listProducts(){
        return productService.listAllProducts();
    }
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deleteProductbyId(@PathVariable Long id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
}
