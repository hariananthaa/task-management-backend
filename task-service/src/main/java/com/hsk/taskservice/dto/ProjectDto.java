package com.hsk.taskservice.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.hsk.taskservice.persistent.entity.Project}
 */
public record ProjectDto(LocalDateTime createdAt, String createdBy, String updatedBy, LocalDateTime updatedAt,
                         Long version, Boolean deleted, Long id, String name, String description,
                         List<TaskDto> task) implements Serializable {
}