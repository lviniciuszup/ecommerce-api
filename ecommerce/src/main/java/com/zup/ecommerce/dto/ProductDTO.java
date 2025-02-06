package com.zup.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientDTO(
    @NotBlank(message = "O nome não pode ser vázio") String name,
    @NotBlank(message = "O cpf não pode ser vázio") String cpf,
    @Email(message = "Insira um email valido por favor!") String email
) {

}
