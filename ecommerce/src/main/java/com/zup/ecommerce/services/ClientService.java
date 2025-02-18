package com.zup.ecommerce.services;

import com.zup.ecommerce.dto.ClientRequestDTO;
import com.zup.ecommerce.dto.ClientResponseDTO;
import com.zup.ecommerce.exceptions.DuplicateException;
import com.zup.ecommerce.exceptions.InvalidException;
import com.zup.ecommerce.exceptions.NotFoundException;
import com.zup.ecommerce.model.Client;
import com.zup.ecommerce.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO){
        String cpfNoMask = clientRequestDTO.getCpf().replaceAll("\\D", "");
        if (clientRepository.existsByCpf(cpfNoMask)){
            throw new DuplicateException("Já existe um cliente com o CPF: "+ cpfNoMask) {
            };
        }
        Client client = new Client(clientRequestDTO.getName(), cpfNoMask, clientRequestDTO.getEmail());
        Client savedCLient = clientRepository.save(client);

        return new ClientResponseDTO(
                savedCLient.getId(),
                savedCLient.getName(),
                savedCLient.getCpf(),
                savedCLient.getEmail()
        );
    }

    public ClientResponseDTO listClientByCpf(String cpf){
        String cpfNoMask = cpf.replaceAll("\\D", "");
        Client existingClientByCpf = clientRepository.findByCpf(cpfNoMask).orElseThrow(()-> new NotFoundException("O cpf " + cpfNoMask + " não foi encontrado.")
        );

        return new ClientResponseDTO(
                existingClientByCpf.getId(),
                existingClientByCpf.getName(),
                existingClientByCpf.getCpf(),
                existingClientByCpf.getEmail());
    }

    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO){
        Client existingClientById = clientRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("O cliente com este o id não existe"));
        existingClientById.setName(clientRequestDTO.getName());
        existingClientById.setEmail(clientRequestDTO.getEmail());

        Client savedCLient = clientRepository.save(existingClientById);

        return new ClientResponseDTO(
                savedCLient.getId(),
                savedCLient.getEmail(),
                savedCLient.getName(),
                savedCLient.getCpf()
        );
    }

}
