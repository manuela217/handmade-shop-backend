package com.handmade.ecommerce.backend.application;

import com.handmade.ecommerce.backend.domain.model.User;
import com.handmade.ecommerce.backend.domain.port.IUserRepository;

public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save (User user) {
        return this.iUserRepository.save(user);
    }

    public User findById(Integer id) {
        return this.iUserRepository.findById(id);
    }
}
