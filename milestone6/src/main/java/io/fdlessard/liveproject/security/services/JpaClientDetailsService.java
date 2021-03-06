package io.fdlessard.liveproject.security.services;

import io.fdlessard.liveproject.entities.Client;
import io.fdlessard.liveproject.repositories.ClientRepository;
import io.fdlessard.liveproject.security.model.ClientDetailsSecurityWrapper;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaClientDetailsService implements ClientDetailsService {

  private final ClientRepository clientRepository;

  public JpaClientDetailsService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
    Optional<Client> client = clientRepository.findClientByClientId(clientId);
    return client
            .map(ClientDetailsSecurityWrapper::new)
            .orElseThrow(() -> new ClientRegistrationException("Client doesn't exist!"));
  }
}
