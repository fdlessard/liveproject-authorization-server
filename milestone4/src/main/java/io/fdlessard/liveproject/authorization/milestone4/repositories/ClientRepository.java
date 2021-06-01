package io.fdlessard.liveproject.authorization.milestone4.repositories;

import io.fdlessard.liveproject.authorization.milestone4.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findUserByClientId(String clientId);

}