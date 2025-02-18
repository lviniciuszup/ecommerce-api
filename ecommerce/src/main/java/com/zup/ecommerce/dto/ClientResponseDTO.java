package com.zup.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClientRequestDTO {
    @NotBlank(message = "O nome não pode ser vazio.")
    private String name;
    @NotBlank(message = "O CPF não pode ser vazio")
    @Pattern(regexp = "\\d{11}", message = "O CPF informado é inválido.")
    private String cpf;
    @Email(message = "O e-mail não pode ser inválido")
    @NotBlank(message = "O e-mail não pode ser vázio")
    private String email;

    public ClientRequestDTO(String email, String cpf, String name) {
        this.email = email;
        this.cpf = cpf;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
