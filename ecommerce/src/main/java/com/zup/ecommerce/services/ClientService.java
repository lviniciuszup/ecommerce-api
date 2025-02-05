package com.zup.ecommerce.services;

import com.zup.ecommerce.model.Product;
import com.zup.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
       if (productRepository.existsByName(product.getName())){
           throw new IllegalArgumentException("Já existe um produto com esse nome.");
       }
        return productRepository.save(product);
    }
    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long id){
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isEmpty()){
            throw new IllegalArgumentException("O produto não existe");
        }
        productRepository.deleteById(id);

    }
}
