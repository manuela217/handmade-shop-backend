package com.handmade.ecommerce.backend.infrastructure.dto;

import com.handmade.ecommerce.backend.domain.model.UserType;

public record JWTClient(Integer id, String token, UserType userType) {
}
