package com.zup.ecommerce.controller;

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

    @PostMapping("/clients")
    public ResponseEntity<Client> newClient(@RequestBody @Valid Client client){
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.status(201).body(createdClient);
    }

    @GetMapping("clients/{cpf}")
    public ResponseEntity<Client> listClientCpf(@PathVariable String cpf){
        try {
            Client client = clientService.listClientByCpf(cpf);
            return ResponseEntity.status(200).body(client);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        try {
            Client updatedClient = clientService.updateClient(id, client);
            return ResponseEntity.status(200).body(updatedClient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).build();
        }
    }
}