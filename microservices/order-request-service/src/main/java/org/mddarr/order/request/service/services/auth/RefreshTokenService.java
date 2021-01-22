package org.mddarr.order.request.service.services.auth;


import lombok.AllArgsConstructor;
import org.mddarr.order.request.service.exceptions.SpringOrdersException;
import org.mddarr.order.request.service.models.RefreshToken;
import org.mddarr.order.request.service.repositories.RefreshTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken() {
        System.out.println("LOGGING IN");
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreated_date(Instant.now());
        refreshToken.setId(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new SpringOrdersException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
