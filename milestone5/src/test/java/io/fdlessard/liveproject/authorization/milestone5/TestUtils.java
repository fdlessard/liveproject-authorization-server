package io.fdlessard.liveproject.authorization.milestone5;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fdlessard.liveproject.authorization.milestone5.domain.Authority;
import io.fdlessard.liveproject.authorization.milestone5.domain.Client;
import io.fdlessard.liveproject.authorization.milestone5.domain.ClientGrantType;
import io.fdlessard.liveproject.authorization.milestone5.domain.User;

import java.util.Arrays;

import static io.fdlessard.liveproject.authorization.milestone5.domain.EncryptionAlgorithm.BCRYPT;

public class TestUtils {

    public static User buildUser() {
        return User.builder()
                .username("testUsername")
                .password("testPassword")
                .algorithm(BCRYPT)
                .authorities(Arrays.asList( buildAuthority()))
                .build();
    }

    public static Authority buildAuthority() {
        return Authority.builder()
                .name("authorityName")
                .build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Client buildClient() {
        return Client.builder()
                .clientId("clientIdTest")
                .secret("secretTest")
                .redirectUri("redirectUrlTest")
                .scope("scopeTest")
                .clientGrantTypes(Arrays.asList(buildClientGrantType()))
                .build();
    }

    public static ClientGrantType buildClientGrantType() {
        return ClientGrantType.builder()
                .clientId(1)
                .grantType("grantType")
                .build();
    }

    private TestUtils() {
    }
}
