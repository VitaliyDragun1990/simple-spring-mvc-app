package com.demo.bankapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping({"/", "/index", "/index*", "/view/*"})
    public String index() {
        return "testRequestMapping";
    }

    @GetMapping("/name")
    public String methodWithParams(
            @RequestParam(value = "userName", required = false, defaultValue = "Guest") String userName,
            Model model) {

        System.out.println("Page requested by " + userName);
        model.addAttribute("userName", userName);
        return "testRequestMapping";
    }

    @GetMapping("/dynamic/{category:[a-z]+}/{userName}")
    public String dynamicUrl(@PathVariable("userName") String userName, Model model) {

        System.out.println("Page requested by " + userName);
        model.addAttribute("userName", userName);
        return "testRequestMapping";
    }

    @RequestMapping("*")
    public String fallBackPage() {
        return "fileNotFound";
    }
}
