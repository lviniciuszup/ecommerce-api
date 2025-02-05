package com.zup.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode ser vázio")
    private String name;
    @Column(unique = true)
    private String cpf;
    @Email(message = "Insira um email valido por favor!")
    @Column(unique = true)
    private String email;


    public String getName() {
        return name;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cpf);
        if (!matcher.matches()){
            throw new IllegalArgumentException("Cpf inválido!");
        }
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client(String name, String cpf, String email, Long id) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.id = id;
    }

}
