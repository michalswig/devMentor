package com.mike.taskmanagement.service;

import com.mike.taskmanagement.dto.GetTaskResponse;
import com.mike.taskmanagement.dto.TaskFilter;
import com.mike.taskmanagement.exception.ResourceNotFoundException;
import com.mike.taskmanagement.model.Task;
import com.mike.taskmanagement.repository.TaskRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;


    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public GetTaskResponse findById(TaskFilter filter) {
        Task task = taskRepository.findById(filter.id())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + filter.id()));
        return GetTaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .createdAt(task.getCreatedAt())
                .editedAt(task.getEditedAt())
                .deletedAt(task.getDeletedAt())
                .build();
    }

}
