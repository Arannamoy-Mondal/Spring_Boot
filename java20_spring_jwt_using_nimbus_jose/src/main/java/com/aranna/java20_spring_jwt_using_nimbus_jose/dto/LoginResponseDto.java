package com.aranna.java20_spring_jwt_using_nimbus_jose.dto;

public record LoginResponseDto(String message,UserDto user,String jwtToken) {

}
