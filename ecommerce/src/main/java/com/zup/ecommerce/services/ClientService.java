package com.zup.ecommerce.services;

import com.zup.ecommerce.model.Client;
import com.zup.ecommerce.repository.ClientRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client){
        if (clientRepository.existsByCpf(client.getCpf())){
            throw new EntityExistsException ("Já existe um cliente com esse CPF!");
        }
        return clientRepository.save(client);
    }

    public Client listClientByCpf(String cpf){
        Optional <Client> existingClient = clientRepository.findByCpf(cpf);
        if (existingClient.isEmpty()){
            throw new IllegalArgumentException("Esse cliente não existe");
        }
        return existingClient.get();
    }

    public Client updateClient(Long id, Client client){
        Optional <Client> existingClientById = clientRepository.findById(id);
        if (existingClientById.isEmpty()){
            throw new IllegalArgumentException("Esse cliente não existe");
        }
        Client existingClient = existingClientById.get();
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setCpf(client.getCpf());

        return clientRepository.save(existingClient);
    }

}
