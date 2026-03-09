package com.handmade.ecommerce.backend.infrastructure.adapter;

import com.handmade.ecommerce.backend.infrastructure.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer> {
}
