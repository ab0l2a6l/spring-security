package com.example.springsecurityv1.controller;

import com.example.springsecurityv1.config.SecurityHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String init() {
        return "index";
    }

    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/user-details")
    public String userDetails(Model model) {
        model.addAttribute("user", SecurityHelper.getCurrentUser());
        return "userDetails";
    }
}
