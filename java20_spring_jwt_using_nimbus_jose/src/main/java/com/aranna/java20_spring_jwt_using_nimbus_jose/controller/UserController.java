package com.aranna.java20_spring_jwt_using_nimbus_jose.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aranna.java20_spring_jwt_using_nimbus_jose.config.JwtTokenGenerate;
import com.aranna.java20_spring_jwt_using_nimbus_jose.dto.LoginRequestDto;
import com.aranna.java20_spring_jwt_using_nimbus_jose.dto.LoginResponseDto;
import com.aranna.java20_spring_jwt_using_nimbus_jose.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerate jwt;
    @PostMapping("/login")
    public ResponseEntity<?> signUp(@org.springframework.web.bind.annotation.RequestBody LoginRequestDto loginRequestDto) {
        try {
            var resultAuthentication=authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(), 
            loginRequestDto.getPassword()));
            var jwtToken=jwt.generatJwtToken(resultAuthentication);
            var userDto = new UserDto();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), userDto, jwtToken));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
}
