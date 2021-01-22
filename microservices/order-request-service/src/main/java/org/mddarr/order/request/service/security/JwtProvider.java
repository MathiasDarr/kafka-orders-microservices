package org.mddarr.order.request.service.security;


import io.jsonwebtoken.Claims;
import org.mddarr.order.request.service.exceptions.SpringOrdersException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
//import java.security;
import java.security.*;
import java.security.cert.CertificateException;
import java.sql.Date;
import java.time.Instant;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.User;

import static io.jsonwebtoken.Jwts.parser;
import static java.util.Date.from;

@Service
public class JwtProvider {

    private KeyStore keystore;
    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;


    @PostConstruct
    public void init(){
        try{
            keystore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keystore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException| IOException e) {
            throw new SpringOrdersException("Exception occurred while loading keystore", e);
        }
    }

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }

    public String generateTokenWithUserName(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }


    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keystore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringOrdersException("Exception occured while retrieving public key from keystore", e);
        }
    }

    public boolean validateToken(String jwt) {
        parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublickey() {
        try {
            return keystore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringOrdersException("Exception occured while " +
                    "retrieving public key from keystore", e);
        }
    }

    public String getUsernameFromJwt(String token) {
        Claims claims = parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }



}
