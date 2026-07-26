package com.handmade.ecommerce.backend.infrastructure.rest;

import com.handmade.ecommerce.backend.application.RegistrationService;
import com.handmade.ecommerce.backend.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/security")
@CrossOrigin(origins = "http://localhost:4200")
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
