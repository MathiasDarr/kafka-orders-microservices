package org.mddarr.authenticationservice.services;

import lombok.AllArgsConstructor;
import org.mddarr.authenticationservice.models.UserEntity;
import org.mddarr.authenticationservice.models.requests.RegisterRequest;
import org.mddarr.authenticationservice.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(RegisterRequest registerRequest){
        UserEntity user = new UserEntity();
        user.setUserid(UUID.randomUUID().toString());
        user.setEmail(registerRequest.getEmail());
        user.setFirst_name(registerRequest.getFirstname());
        user.setLast_name(registerRequest.getLastname());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setUpdate_ts(new Date(System.currentTimeMillis()));
        userRepository.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

}
