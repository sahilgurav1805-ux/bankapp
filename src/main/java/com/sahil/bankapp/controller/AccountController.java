package com.sahil.bankapp.controller;

import com.sahil.bankapp.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServices accountService;

    // CREATE ACCOUNT
    @PostMapping("/create")
    public String createAccount(@RequestParam String name,
                                @RequestParam long accountNumber,
                                @RequestParam double balance) {

        return accountService.createAccount(name, accountNumber, balance);
    }

    // DEPOSIT MONEY
    @PostMapping("/deposit")
    public String deposit(@RequestParam long accountNumber,
                          @RequestParam double amount) {

        return accountService.deposit(accountNumber, amount);
    }

    // WITHDRAW MONEY
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam long accountNumber,
                           @RequestParam double amount) {

        return accountService.withdraw(accountNumber, amount);
    }

    // MINI STATEMENT
    @GetMapping("/statement")
    public Object getStatement(@RequestParam long accountNumber) {
        return accountService.getMiniStatement(accountNumber);
    }
}