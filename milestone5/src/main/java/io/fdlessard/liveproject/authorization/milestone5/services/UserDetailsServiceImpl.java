package io.fdlessard.liveproject.authorization.milestone5.services;

import io.fdlessard.liveproject.authorization.milestone5.domain.User;
import io.fdlessard.liveproject.authorization.milestone5.domain.UserDetailsWrapper;
import io.fdlessard.liveproject.authorization.milestone5.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        Optional<User> optional = userRepository.findUserByUsername(username);
        if(optional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        return new UserDetailsWrapper(optional.get());
    }

}
