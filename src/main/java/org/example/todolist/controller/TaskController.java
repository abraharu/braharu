package org.example.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.dto.TaskCreateDto;
import org.example.todolist.entity.Task;
import org.example.todolist.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getUserTasks(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @PostMapping
    public Task addTask(Authentication auth, @ModelAttribute TaskCreateDto taskDto) throws IOException {
        MultipartFile file = taskDto.getFile();
        String filePath = null;

        if (file != null && !file.isEmpty()) {
            filePath = taskService.saveFile(file);
        }

        Task buildTask = Task.builder()
                .description(taskDto.getDescription())
                .completed(taskDto.isCompleted())
                .filePath(filePath)
                .build();

        return taskService.addTask(auth.getName(), buildTask);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @ModelAttribute TaskCreateDto taskDto) throws IOException {
        MultipartFile file = taskDto.getFile();

        Task existingTask = taskService.getTaskById(id);

        if (file != null && !file.isEmpty()) {
            String filePath = taskService.saveFile(file);
            existingTask.setFilePath(filePath);
        }

        existingTask.setDescription(taskDto.getDescription());
        existingTask.setCompleted(taskDto.isCompleted());

        return taskService.updateTask(id, existingTask);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }
}