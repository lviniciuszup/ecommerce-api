package com.zup.ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ProductRequestDTO {
    @NotBlank(message = "O nome do produto não pode ser vázio.")
    private String name;
    @NotNull(message = "O preço não pode ser nulo")
    @Min(value = 0, message= "O preço deve ser maior que 0" )
    private Double price;
    @NotNull(message = "O preço não pode ser nulo")
    @Min(value = 0, message= "A quantidade em estoque deve ser maior que 0" )
    private Integer quantity;


    public ProductRequestDTO(Long id, String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
