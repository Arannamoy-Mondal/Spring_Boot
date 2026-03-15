package com.aranna.java20_spring_jwt_using_nimbus_jose.config;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtTokenValidatorFilter extends OncePerRequestFilter {
    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final Environment environment;
    @Qualifier("publicPaths")
    private final List<String> publicPaths;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header=environment.getProperty("JWT_HEADER");
        String authHeader=request.getHeader(header);
        if(authHeader!=null){
            try {
                String jwt=authHeader.substring(7);
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}
