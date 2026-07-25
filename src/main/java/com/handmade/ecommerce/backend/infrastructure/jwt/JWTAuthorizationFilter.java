package com.handmade.ecommerce.backend.infrastructure.jwt;

import com.handmade.ecommerce.backend.infrastructure.config.JwtProperties;
import com.handmade.ecommerce.backend.infrastructure.service.CustomUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.handmade.ecommerce.backend.infrastructure.jwt.JWTValidate.*;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final CustomUserDetailService customUserDetailService;
    private final JwtProperties jwtProperties;

    public JWTAuthorizationFilter(CustomUserDetailService customUserDetailService, JwtProperties jwtProperties) {
        this.customUserDetailService = customUserDetailService;
        this.jwtProperties = jwtProperties;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (tokenExists(request,response)) {
                Claims claims = JWTValid(request, jwtProperties.getSecret());
                if (claims.get("authorities") != null) {
                    setAuthentication(claims,customUserDetailService);
                } else  {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request,response);

        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

    }
}
