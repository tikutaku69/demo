package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        System.out.println("htmlを呼ぶ");
        return "hello";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String message) {
        System.out.println("hello呼ばれた");

        return "受け取った値：" + message;
    }
}