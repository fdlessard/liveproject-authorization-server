package io.fdlessard.liveproject.authorization.milestone2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static io.fdlessard.liveproject.authorization.milestone2.EncryptionAlgorithm.BCRYPT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void createUser() throws Exception {
        mockMvc.perform(post("/users")
        .content(asJsonString(buildUser()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk());

    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    User buildUser() {
        return User.builder()
                .username("testUsername")
                .password("testPassword")
                .algorithm(BCRYPT)
                .authorities(Arrays.asList( buildAuthority()))
                .build();
    }

    Authority buildAuthority() {
        return Authority.builder()
                .name("authorityName")
                .build();
    }

}