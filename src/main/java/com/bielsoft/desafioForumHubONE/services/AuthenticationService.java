package com.bielsoft.desafioForumHubONE.services;

import com.bielsoft.desafioForumHubONE.dtos.TokenDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public TokenDTO authenticated(Authentication authentication){
        return jwtService.gerarToken(authentication);
    }

}
