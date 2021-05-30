package io.fdlessard.liveproject.authorization.milestone2;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public void createUser(User user) {

        Optional<User> u = userRepository.findUserByUsername(user.getUsername());

        if (u.isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getAuthorities().forEach(a -> a.setUser(user));
            userRepository.save(user);
        } else {
            throw new RuntimeException("User already exists! You cannot add it twice.");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
