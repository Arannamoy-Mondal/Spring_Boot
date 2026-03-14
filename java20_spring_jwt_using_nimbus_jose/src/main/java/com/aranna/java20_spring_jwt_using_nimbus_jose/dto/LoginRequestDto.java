package com.aranna.java20_spring_jwt_using_nimbus_jose.dto;

import lombok.Data;

@Data
public class LoginRequestDto{
    private String userName;
    private String password;
}   
