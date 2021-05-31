package io.fdlessard.liveproject.authorization.milestone3;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fdlessard.liveproject.authorization.milestone3.domain.Authority;
import io.fdlessard.liveproject.authorization.milestone3.domain.Client;
import io.fdlessard.liveproject.authorization.milestone3.domain.ClientGrantType;
import io.fdlessard.liveproject.authorization.milestone3.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static io.fdlessard.liveproject.authorization.milestone3.domain.EncryptionAlgorithm.BCRYPT;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void createClient() throws Exception {
        mockMvc.perform(post("/clients")
        .content(asJsonString(buildClient()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Client buildClient() {
        return Client.builder()
                .clientId("clientIdTest")
                .secret("secretTest")
                .redirectUri("redirectUrlTest")
                .scope("scopeTest")
                .clientGrantTypes(Arrays.asList(buildClientGrantType()))
                .build();
    }

    ClientGrantType buildClientGrantType() {
        return ClientGrantType.builder()
                .clientId(1)
                .grantType("grantType")
                .build();
    }

}