package com.zup.ecommerce.repository;

import com.zup.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    default boolean existsByName(String name){
        return findByName(name).isPresent();
    }
}
