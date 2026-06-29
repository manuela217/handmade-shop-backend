package com.handmade.ecommerce.backend.application;

import com.handmade.ecommerce.backend.domain.model.User;
import com.handmade.ecommerce.backend.domain.port.IUserRepository;

public class RegistrationService {
    private final IUserRepository iUserRepository;

    public RegistrationService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User register (User user) {
        return iUserRepository.save(user);
    }
}
