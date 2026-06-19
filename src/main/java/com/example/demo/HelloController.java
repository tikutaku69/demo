package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        System.out.println("htmlを呼ぶ");
        return "hello";
    }

    @PostMapping("/hello")
    public String hello(@ModelAttribute HelloForm form, Model model) {
        System.out.println("hello呼ばれた");

        model.addAttribute("message", form.getMessage());
        model.addAttribute("message2", form.getMessage2());
        return "result";
    }
}