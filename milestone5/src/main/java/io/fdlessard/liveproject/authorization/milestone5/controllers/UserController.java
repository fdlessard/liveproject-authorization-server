package io.fdlessard.liveproject.authorization.milestone5.controllers;

import io.fdlessard.liveproject.authorization.milestone5.domain.User;
import io.fdlessard.liveproject.authorization.milestone5.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;

    @GetMapping("/users/{id}")
    public User get(@PathVariable Integer id) {
        return userService.getUserById(id).get();
    }

    @GetMapping("/users")
    public List<User> get() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    @ResponseStatus( HttpStatus.CREATED)
    public void post(@RequestBody User user) {
        userService.createUser(user);
    }

}
