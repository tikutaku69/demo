package com.example.demo;

import com.example.demo.dto.Task;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "hello";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {

        Optional<Task> task = taskService.getTaskById(id);

        model.addAttribute("task", task.get());

        return "edit";
    }

    @PostMapping("/task")
    public String addTask(@RequestParam String title) {

        taskService.addTask(title);

        return "redirect:/";
    }

    @PostMapping("/tasks/update")
    public String updateTask(@RequestParam Long id, @RequestParam String title) {

        taskService.updateTask(id, title);

        return "redirect:/";
    }
}