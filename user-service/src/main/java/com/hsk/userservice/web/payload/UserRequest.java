package com.hsk.userservice.web.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(

        @NotBlank(message = "User name is required.")
        String username,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email.")
        String email,

        String password
) {
}
