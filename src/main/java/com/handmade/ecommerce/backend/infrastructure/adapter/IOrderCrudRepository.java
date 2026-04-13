package com.handmade.ecommerce.backend.infrastructure.adapter;

import com.handmade.ecommerce.backend.domain.model.OrderState;
import com.handmade.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.handmade.ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderState = :state WHERE o.id = :id")
    void updateStateById(@Param("id") Integer id, @Param("state") OrderState state);

    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);
}
