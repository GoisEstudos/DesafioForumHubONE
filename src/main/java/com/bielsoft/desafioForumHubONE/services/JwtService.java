package com.bielsoft.desafioForumHubONE.services;

import com.bielsoft.desafioForumHubONE.dtos.TokenDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public TokenDTO gerarToken(Authentication authentication) {
        Instant now = Instant.now();
        long expireTime = 3600L;

        String scopes = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        var claim = JwtClaimsSet.builder()
                .issuer("desafioForumHubONE")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expireTime))
                .subject(authentication.getName())
                .claim("scope", scopes)
                .build();

        var token = jwtEncoder.encode(JwtEncoderParameters.from(claim)).getTokenValue();
        return new TokenDTO(token);
    }
}
