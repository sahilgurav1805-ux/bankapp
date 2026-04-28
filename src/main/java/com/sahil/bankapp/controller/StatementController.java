package com.sahil.bankapp.controller;

import com.sahil.bankapp.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StatementController {

    @Autowired
    private AccountServices accountService;

    @GetMapping("/statement")
    public String showPage() {
        return "statement";
    }

    @PostMapping("/statement")
    public String getStatement(@RequestParam long accountNumber, Model model) {
        model.addAttribute("transactions",
                accountService.getMiniStatement(accountNumber));
        return "statement";
    }
}