package com.hsk.projectservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hsk.projectservice.persistent.entity.Project;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.hsk.projectservice.persistent.entity.Task}
 */
public record TaskDto(@JsonProperty(value = "created_at")
                      LocalDateTime createdAt,
                      @JsonProperty(value = "created_by")
                      String createdBy,
                      @JsonProperty(value = "updated_at")
                      LocalDateTime updatedAt,
                      @JsonProperty(value = "updated_by")
                      String updatedBy,
                      Long id, String title,

//                      @JsonProperty("project_key")
//                      Project project,
                      String description, String status,
                      String priority,
                      @JsonProperty("due_date")
                      LocalDateTime dueDate) implements Serializable {
}