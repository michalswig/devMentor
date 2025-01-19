package com.mike.taskmanagement.controller;

import com.mike.taskmanagement.dto.GetTaskResponse;
import com.mike.taskmanagement.dto.TaskFilter;
import com.mike.taskmanagement.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class WebController {

    private TaskService taskService;

    public WebController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        log.info("Fetching task with id: {}", id);
        TaskFilter filter = new TaskFilter(id);
        GetTaskResponse task = taskService.findById(filter);

        if (task != null) {
            log.info("Task found: {}", task);
            model.addAttribute("task", task);
            return "task";
        } else {
            log.error("Task not found with id: {}", id);
            model.addAttribute("error", "Task not found!");
            return "error";
        }
    }

}
