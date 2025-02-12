package com.zup.ecommerce.controller;

import com.zup.ecommerce.dto.ClientDTO;
import com.zup.ecommerce.model.Client;
import com.zup.ecommerce.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientController{
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<Client> newClient(@RequestBody @Valid ClientDTO clientDTO){
        Client client = new Client(clientDTO.name(), clientDTO.cpf(), clientDTO.email());
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.status(201).body(createdClient);
    }

    @GetMapping("clientes/{cpf}")
    public ResponseEntity<Client> listClientCpf(@PathVariable String cpf){
        try {
            Client client = clientService.listClientByCpf(cpf);
            return ResponseEntity.status(200).body(client);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        try {
            Client updatedClient = new Client(clientDTO.name(), clientDTO.cpf(), clientDTO.email());
            updatedClient = clientService.updateClient(id, updatedClient);
            return ResponseEntity.status(200).body(updatedClient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).build();
        }
    }
}