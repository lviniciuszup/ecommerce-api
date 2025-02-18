package com.zup.ecommerce.services;


import com.zup.ecommerce.dto.ProductRequestDTO;
import com.zup.ecommerce.dto.ProductResponseDTO;
import com.zup.ecommerce.exceptions.DuplicateException;
import com.zup.ecommerce.exceptions.NotFoundException;
import com.zup.ecommerce.model.Product;
import com.zup.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
       if (productRepository.existsByName(productRequestDTO.getName())){
           throw new DuplicateException("Já existe um produto com o nome: " + productRequestDTO.getName()) {
           };
       }
        Product product = new Product(productRequestDTO.getName(), productRequestDTO.getPrice(), productRequestDTO.getQuantity());
        Product savedProduct = productRepository.save(product);

        return new ProductResponseDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getQuantity()
        );
    }
    public List<ProductResponseDTO> listAllProducts(){
        return productRepository.findAll().stream()
                .map(product -> new ProductResponseDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity()
                )).collect(Collectors.toList());
    }

    public void deleteProduct(Long id){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não existe um produto com esse id"));
        productRepository.deleteById(id);
    }
}
