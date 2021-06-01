package io.fdlessard.liveproject.authorization.milestone4.repositories;

import io.fdlessard.liveproject.authorization.milestone4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String u);
}