package com.zup.ecommerce.repository;

import com.zup.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByCpf(String cpf);
    Optional<Client> findByCpf(String cpf);
}
