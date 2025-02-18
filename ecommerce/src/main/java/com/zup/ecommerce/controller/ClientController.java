package com.zup.ecommerce.controller;

import com.zup.ecommerce.dto.ClientRequestDTO;
import com.zup.ecommerce.dto.ClientResponseDTO;
import com.zup.ecommerce.model.Client;
import com.zup.ecommerce.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientController{
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }


    @PostMapping("clientes")
    public ResponseEntity<ClientResponseDTO> newClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientRequestDTO));
    }

    @GetMapping("clientes/{cpf}")
    public ResponseEntity<ClientResponseDTO> listClientCpf(@PathVariable String cpf){
        String cleanCpf = cpf.replaceAll("[^0-9]", "");
            return ResponseEntity.ok(clientService.listClientByCpf(cpf));

    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @RequestBody @Valid ClientRequestDTO clientRequestDTO) {
         try{ ClientResponseDTO updatedClient = clientService.updateClient(id, clientRequestDTO);
            return ResponseEntity.ok().body(updatedClient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}