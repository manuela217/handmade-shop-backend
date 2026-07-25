package com.handmade.ecommerce.backend.infrastructure.jwt;

import com.handmade.ecommerce.backend.infrastructure.service.CustomUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import static com.handmade.ecommerce.backend.infrastructure.jwt.Constants.*;

public class JWTValidate {
    public static boolean tokenExists(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader(HEADER_AUTHORIZATION);
        return header != null && header.startsWith(TOKEN_BEARER_PREFIX);
    }

    public static Claims JWTValid(HttpServletRequest request, String secretKey) {
        String jwtToken = request.getHeader(HEADER_AUTHORIZATION).replace(TOKEN_BEARER_PREFIX,"");
        return Jwts.parserBuilder()
                .setSigningKey(getSignedKey(secretKey))
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    public static void setAuthentication(Claims claims, CustomUserDetailService customUserDetailService) {
        UserDetails userDetails = customUserDetailService.loadUserByUsername(claims.getSubject());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
