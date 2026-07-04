package com.handmade.ecommerce.backend.infrastructure.rest;

import com.handmade.ecommerce.backend.infrastructure.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/security")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.email(),userDTO.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("Se ha iniciado sesión correctamente", HttpStatus.OK);
    }
}
