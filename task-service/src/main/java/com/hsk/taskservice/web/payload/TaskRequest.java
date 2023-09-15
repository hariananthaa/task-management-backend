package com.hsk.taskservice.web.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hsk.taskservice.web.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
public record TaskRequest(

        @NotBlank(message = "Title is required.")
        String title,
        String description,
        Priority priority,

        @JsonProperty("due_date")
        LocalDateTime dueDate
) {
}
