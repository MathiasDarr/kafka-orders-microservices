package org.mddarr.order.request.service.authorization;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mddarr.order.request.service.dto.RegisterRequest;
import org.mddarr.order.request.service.repositories.UserRepository;
import org.mddarr.order.request.service.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorizationServiceIntegrationTests {

    @MockBean
    UserRepository userRepository;

    @Autowired
    AuthService authService;

    @Test
    void testPostPatient(){
        String firstname = "Charles";
        String lastname = "Woodson";
        String email = "cwoodson@yahoo.com";
        String password = "password";

        RegisterRequest postProviderRequest = RegisterRequest.builder()
                .email(email)
                .firstname(firstname)
                .lastname(lastname)
                .password(password)
                .build();
        authService.register(postProviderRequest);
    }


}
