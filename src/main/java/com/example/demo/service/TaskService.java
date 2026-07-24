package com.example.demo.service;

import com.example.demo.dto.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String title) {
        Task task = new Task(title);
        taskRepository.save(task);
    }

    public void updateTask(Long id, String title) {
        Optional<Task> task = taskRepository.findById(id);
        Task updateTask = task.get();  //ここでOptionalからTask型を取り出す
        updateTask.setTitle(title);  //Task型だからsetTitleを呼べる
        taskRepository.save(updateTask);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
}
