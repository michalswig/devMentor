package com.mike.taskmanagement.dto;

import java.time.LocalDateTime;

public record TaskFilter(
        Long id,
        String title,
        String description,
        Boolean completed,
        LocalDateTime createdAt,
        LocalDateTime editedAt,
        LocalDateTime deletedAt
) {
    public TaskFilter(Long id) {
        this(id, null, null, null, null, null, null);
    }
}
