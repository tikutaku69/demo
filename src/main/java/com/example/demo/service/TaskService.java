package com.example.demo.service;

import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String task) {
        taskRepository.save(task);
    }

    public List<String> getAllTasks() {
        return taskRepository.findAll();
    }
}
