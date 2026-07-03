package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String createMessage(String message) {
        if (message == null || message.isBlank()) {
            return "入力項目1つ目が未入力です";
        }
        return "こんにちは、" + message;
    }
}
