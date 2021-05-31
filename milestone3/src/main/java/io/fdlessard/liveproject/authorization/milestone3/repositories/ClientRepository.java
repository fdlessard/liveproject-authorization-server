package io.fdlessard.liveproject.authorization.milestone3.repositories;

import io.fdlessard.liveproject.authorization.milestone3.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findUserByClientId(String clientId);

}