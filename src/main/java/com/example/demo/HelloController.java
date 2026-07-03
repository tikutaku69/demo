package com.example.demo;

import com.example.demo.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String index() {
        System.out.println("htmlを呼ぶ");
        return "hello";
    }

    @PostMapping("/hello")
    public String hello(@ModelAttribute HelloForm form, Model model) {
        System.out.println("hello呼ばれた");

        String message = helloService.createMessage(form.getMessage());

        model.addAttribute("message", message);
        model.addAttribute("message2", form.getMessage2());
        return "result";
    }
}