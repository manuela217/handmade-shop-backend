package com.handmade.ecommerce.backend.application;

import com.handmade.ecommerce.backend.domain.model.User;
import com.handmade.ecommerce.backend.domain.port.IUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegistrationService {
    private final IUserRepository iUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegistrationService(IUserRepository iUserRepository,BCryptPasswordEncoder passwordEncoder) {
        this.iUserRepository = iUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register (User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return iUserRepository.save(user);
    }
}
