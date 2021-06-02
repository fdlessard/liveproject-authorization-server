package io.fdlessard.liveproject.authorization.milestone5.services;

import io.fdlessard.liveproject.authorization.milestone5.domain.Client;
import io.fdlessard.liveproject.authorization.milestone5.domain.ClientDetailsWrapper;
import io.fdlessard.liveproject.authorization.milestone5.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws UsernameNotFoundException, DataAccessException {

        Optional<Client> optional = clientRepository.findUserByClientId(clientId);
        if (optional.isEmpty()) {
            throw new RuntimeException("Client not found!");
        }
        Client client = optional.get();

        return new ClientDetailsWrapper(client);

    }

}
