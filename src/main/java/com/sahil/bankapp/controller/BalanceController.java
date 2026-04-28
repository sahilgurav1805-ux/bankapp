package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BalanceController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/balance")
    public String showPage() {
        return "balance";
    }

    @PostMapping("/balance")
    public String checkBalance(@RequestParam Long accountNumber,
                               @RequestParam String pin,
                               Model model) {

        Optional<Account> accOpt = accountRepository.findByAccountNumber(accountNumber);

        if (accOpt.isEmpty()) {
            model.addAttribute("error", "Account not found");
            return "balance";
        }

        Account account = accOpt.get();

        if (account.getPin() == null || !account.getPin().equals(pin)) {
            model.addAttribute("error", "Invalid PIN");
            return "balance";
        }

        model.addAttribute("balance", account.getBalance());
        model.addAttribute("name", account.getName());

        return "balance";
    }
}