package com.hsk.projectservice.web.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record GetAllTaskRequest(
        @NotBlank(message = "Project key is required.")
        @Pattern(regexp = "^[A-Z]+-*[A-Z]*$",message = "Key must contains only alphabets.")
        String projectKey
) {
}
