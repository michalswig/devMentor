package com.mike.taskmanagement.controller;


import com.mike.taskmanagement.dto.GetTaskResponse;
import com.mike.taskmanagement.dto.TaskFilter;
import com.mike.taskmanagement.model.Task;
import com.mike.taskmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        Task savedTask = taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetTaskResponse> findById(@PathVariable Long id) {
        TaskFilter filter = new TaskFilter(id);
        GetTaskResponse task = taskService.findById(filter);
        return ResponseEntity.ok(task);
    }

}
