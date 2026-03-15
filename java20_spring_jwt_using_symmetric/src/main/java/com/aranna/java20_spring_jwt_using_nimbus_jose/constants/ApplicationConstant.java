package com.aranna.java20_spring_jwt_using_nimbus_jose.constants;

public class ApplicationConstant {
    private ApplicationConstant(){
        throw new AssertionError("Application class can not be initialized");
    }

    public static final String JWT_SECRET_TOKEN="JWT_SECRET";
    public static final String JWT_SECRET_DEFAULT_VALUE="";
}
