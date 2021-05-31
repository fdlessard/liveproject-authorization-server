package io.fdlessard.liveproject.authorization.milestone3;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    public List<Clients> getAllClients() {
        return clientRepository.findAll();
    }

    public void createClient(Clients clients) {

        Optional<Clients> c = clientRepository.findUserByClientId(clients.getClientId());

        if (c.isEmpty()) {
            clientRepository.save(clients);
        } else {
            throw new RuntimeException("Client already exists! You cannot add it twice.");
        }
    }

}
