package io.fdlessard.liveproject.authorization.milestone5;

import io.fdlessard.liveproject.authorization.milestone5.services.ClientDetailsServiceImpl;
import io.fdlessard.liveproject.authorization.milestone5.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.provider.ClientDetails;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ClientDetailsServiceImplTest {

    @Autowired
    private ClientDetailsServiceImpl clientDetailsService;

    @Autowired
    private ClientService clientService;

    @Test
    void loadClientByClientIdException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            clientDetailsService.loadClientByClientId("toto");
        });
    }

    @Test
    void loadClientByClientId() {

        clientService.createClient(TestUtils.buildClient());
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId("clientIdTest");
        assertNotNull(clientDetails);
    }

}