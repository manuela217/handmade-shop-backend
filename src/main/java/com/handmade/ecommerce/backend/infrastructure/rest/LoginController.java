package com.handmade.ecommerce.backend.infrastructure.rest;

import com.handmade.ecommerce.backend.application.UserService;
import com.handmade.ecommerce.backend.domain.model.User;
import com.handmade.ecommerce.backend.infrastructure.dto.JWTClient;
import com.handmade.ecommerce.backend.infrastructure.dto.UserDTO;
import com.handmade.ecommerce.backend.infrastructure.jwt.JWTGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/security")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;
    private final UserService userService;

    public LoginController(AuthenticationManager authenticationManager, JWTGenerator jwtGenerator, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTClient> login(@RequestBody UserDTO userDTO) {
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.email(),userDTO.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        log.info("Rol de usuario: {}",SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get().toString());

        User user = userService.findByEmail(userDTO.email());

        String token = jwtGenerator.getToken(userDTO.email());
        JWTClient jwtClient = new JWTClient(user.getId(),token, user.getUserType());

        return new ResponseEntity<>(jwtClient, HttpStatus.OK);
    }
}
