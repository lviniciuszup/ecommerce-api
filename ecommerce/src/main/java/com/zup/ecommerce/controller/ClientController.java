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
    //Recebemos o clientDTO com as validações
    public ResponseEntity<Client> newClient(@RequestBody @Valid ClientDTO clientDTO){
        //Criamos um novo cliente a partir do parametro
        Client client = new Client(clientDTO.name(), clientDTO.cpf(), clientDTO.email());
        //Chamamos o service com o metodo criar client que vai salvar no banco de dados
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.status(201).body(createdClient);
    }

    @GetMapping("clientes/{cpf}")
    public ResponseEntity<Client> listClientCpf(@PathVariable String cpf){
        try {
            //Chamamos o service com o metodo para listar os clientes pelo cpf
            Client client = clientService.listClientByCpf(cpf);
            return ResponseEntity.status(200).body(client);
        }catch (IllegalArgumentException e){
            //Retorna not found se não achar
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        try {
            //Criamos o client que vai ser atualizado a partir do DTO
            Client updatedClient = new Client(clientDTO.name(), clientDTO.cpf(), clientDTO.email());
            //com o dados do dto chamamos o metodo que vai atualizar o client
            updatedClient = clientService.updateClient(id, updatedClient);
            // retorna status 200 com ok
            return ResponseEntity.status(200).body(updatedClient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).build();
        }
    }
}