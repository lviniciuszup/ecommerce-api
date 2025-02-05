package com.zup.ecommerce.repository;

import com.zup.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Metodo que busca um produto pelo nome, pode retornar um produto ou nao.
    Optional<Product> findByName(String name);

    //Verifica se o metodo tem algum retorno, isPresent informa se existe
    default boolean existsByName(String name){
        return findByName(name).isPresent();
    }
}
