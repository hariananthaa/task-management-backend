package com.hsk.projectservice.web.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hsk.projectservice.web.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
public record TaskRequest(

        @NotBlank(message = "Project Key is required.")
        @JsonProperty("project_key")
        String projectKey,

        @NotBlank(message = "Title is required.")
        String title,
        String description,
        Priority priority,

        @JsonProperty("due_date")
        LocalDateTime dueDate
) {
}
