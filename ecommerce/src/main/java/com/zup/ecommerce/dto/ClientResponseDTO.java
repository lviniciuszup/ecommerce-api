package com.zup.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClientResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;

    public ClientResponseDTO(Long id, String name, String cpf, String email ) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id;}

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
