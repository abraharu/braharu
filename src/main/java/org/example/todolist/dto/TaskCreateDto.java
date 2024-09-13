package org.example.todolist.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TaskCreateDto {
    private String description;
    private boolean completed;
    private MultipartFile file;
}
