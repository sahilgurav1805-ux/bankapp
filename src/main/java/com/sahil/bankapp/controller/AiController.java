package com.sahil.bankapp.controller;

import com.sahil.bankapp.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    private AiService aiService;

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        return aiService.getResponse(message);
    }
}