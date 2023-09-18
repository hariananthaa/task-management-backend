package com.hsk.projectservice.web.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProjectRequest(

        @NotBlank(message = "Project name is required.")
        String name,
        @NotBlank(message = "Key is required.")
        @Pattern(regexp = "^[A-Z]+(-[A-Z]+)*$",message = "Key must contains only alphabets.")
        String key,
        String description
) {
}
