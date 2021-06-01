package io.fdlessard.liveproject.authorization.milestone4;

import io.fdlessard.liveproject.authorization.milestone4.services.UserDetailsServiceImpl;
import io.fdlessard.liveproject.authorization.milestone4.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @Test
    void loadUserByUsernameException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userDetailsService.loadUserByUsername("toto");
        });

    }

    @Test
    void loadUserByUsername() {

        userService.createUser(TestUtils.buildUser());
        UserDetails userDetails = userDetailsService.loadUserByUsername("testUsername");
        assertNotNull(userDetails);
    }

}