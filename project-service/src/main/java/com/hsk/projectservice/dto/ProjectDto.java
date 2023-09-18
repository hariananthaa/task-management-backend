package com.hsk.projectservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hsk.projectservice.persistent.entity.Project;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Project}
 */
public record ProjectDto(@JsonProperty(value = "created_at")
                         LocalDateTime createdAt,
                         @JsonProperty(value = "created_by")
                         String createdBy,
                         @JsonProperty(value = "updated_at")
                         LocalDateTime updatedAt,
                         @JsonProperty(value = "updated_by")
                         String updatedBy,
                          Long id, String name,String key, String description) implements Serializable {
}