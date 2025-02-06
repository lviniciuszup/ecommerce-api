package com.zup.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductDTO(
    @NotBlank(message = "O nome não pode ser vázio") String name,
    @Positive(message = "O preço deve ser maior que 0")  Double price,
    @Min(value = 0, message = "A quantidade não pode ser negativa") Integer quantity
) {
}
