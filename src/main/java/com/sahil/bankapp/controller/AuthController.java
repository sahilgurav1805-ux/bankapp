package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AccountRepository repo;

    @PostMapping("/login")
    public String login(@RequestParam Long accountNumber,
                        @RequestParam String pin) {

        Optional<Account> acc = repo.findByAccountNumberAndPin(accountNumber, pin);

        if (acc.isPresent()) {
            return "Login Successful ✅ Welcome " + acc.get().getName();
        }

        return "Invalid credentials ❌";
    }
}