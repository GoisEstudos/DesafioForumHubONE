package com.bielsoft.desafioForumHubONE.controllers;

import com.bielsoft.desafioForumHubONE.dtos.LoginDTO;
import com.bielsoft.desafioForumHubONE.dtos.TokenDTO;
import com.bielsoft.desafioForumHubONE.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> efetuarLogin(Authentication authentication) {
        return ResponseEntity.ok(authenticationService.authenticated(authentication));
    }
}
