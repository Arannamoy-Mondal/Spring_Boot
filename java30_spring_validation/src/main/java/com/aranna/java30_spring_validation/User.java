package com.aranna.java30_spring_validation;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // @NotNull
    private Integer id;
    @NotBlank(message = "Name required")
    private String name;
}
