package com.hsk.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.hsk.userservice.persistent.entity.User}
 */
public record UserDto(
        @JsonProperty(value = "created_at")
        LocalDateTime createdAt,
        @JsonProperty(value = "created_by")
        String createdBy,
        @JsonProperty(value = "updated_at")
        LocalDateTime updatedAt,
        @JsonProperty(value = "updated_by")
        String updatedBy,
        Long id,

        String username, String email,
                      String password) implements Serializable {
}