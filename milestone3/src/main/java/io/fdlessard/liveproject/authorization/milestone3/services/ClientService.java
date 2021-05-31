package io.fdlessard.liveproject.authorization.milestone3.services;

import io.fdlessard.liveproject.authorization.milestone3.domain.Client;
import io.fdlessard.liveproject.authorization.milestone3.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void createClient(Client client) {

        Optional<Client> c = clientRepository.findUserByClientId(client.getClientId());

        if (c.isEmpty()) {
            clientRepository.save(client);
        } else {
            throw new RuntimeException("Client already exists! You cannot add it twice.");
        }
    }

}
