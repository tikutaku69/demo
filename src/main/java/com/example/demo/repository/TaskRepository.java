package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<String> tasks = new ArrayList<>();

    public void save(String task) {
        tasks.add(task);
    }

    public List<String> findAll() {
        return tasks;
    }
}
