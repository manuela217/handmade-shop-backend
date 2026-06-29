package com.handmade.ecommerce.backend.infrastructure.rest;

import com.handmade.ecommerce.backend.application.RegistrationService;
import com.handmade.ecommerce.backend.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/security")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody User user) {
        return new ResponseEntity<>(registrationService.register(user), HttpStatus.CREATED);
    }
}
