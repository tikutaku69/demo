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
    public String hello(@RequestParam String message, @RequestParam String message2, Model model) {
        System.out.println("hello呼ばれた");

        model.addAttribute("message", message);
        model.addAttribute("message2", message2);
        return "result";
    }
}