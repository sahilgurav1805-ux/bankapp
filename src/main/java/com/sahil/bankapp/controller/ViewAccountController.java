package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ViewAccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts")
    public String showPage() {
        return "accounts";
    }

    @PostMapping("/accounts")
    public String viewAccount(@RequestParam Long accountNumber,
                              Model model) {

        Optional<Account> account =
                accountRepository.findByAccountNumber(accountNumber);

        if (account.isEmpty()) {
            model.addAttribute("error", "Account not found");
            return "accounts";
        }

        model.addAttribute("account", account.get());
        return "accounts";
    }
}