package com.sahil.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/ai")
    public String aiPage() {
        return "ai";
    }

    @GetMapping("/dashboard-home")
    public String aiDashboard() {
        return "dashboard";
    }

}