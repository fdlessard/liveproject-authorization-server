package io.fdlessard.liveproject.authorization.milestone3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Clients, Integer> {

    Optional<Clients> findUserByClientId(String clientId);

}