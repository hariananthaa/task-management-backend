package com.hsk.taskservice.api.payload;

import com.hsk.taskservice.api.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
public record TaskRequest(

        @NotBlank(message = "Title is required.")
        String title,
        String description,
        Priority priority,
        LocalDateTime dueDate
) {
}
