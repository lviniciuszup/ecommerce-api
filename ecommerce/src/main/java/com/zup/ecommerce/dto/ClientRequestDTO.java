package com.zup.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public class ClientRequestDTO {
    @NotBlank(message = "O nome do cliente não pode ser vazio.")
    private String name;
    @NotBlank(message = "O CPF não pode ser vazio")
    @CPF(message = "O cpf deve ser válido!")
    private String cpf;
    @Email(message = "O e-mail não pode ser inválido")
    @NotBlank(message = "O e-mail não pode ser vázio")
    private String email;

    public ClientRequestDTO(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
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
