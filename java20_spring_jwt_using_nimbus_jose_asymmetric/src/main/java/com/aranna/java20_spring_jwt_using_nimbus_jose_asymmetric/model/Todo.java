package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    String userName;
    String description;
}
