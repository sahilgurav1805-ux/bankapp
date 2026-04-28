package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DepositController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/deposit")
    public String showDepositPage() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String depositMoney(@RequestParam Long accountNumber,
                               @RequestParam String pin,
                               @RequestParam double amount,
                               Model model) {

        Optional<Account> accOpt = accountRepository.findByAccountNumber(accountNumber);

        if (accOpt.isEmpty()) {
            model.addAttribute("error", "Account not found");
            return "deposit";
        }

        Account account = accOpt.get();

        // PIN check
        if (account.getPin() == null || !account.getPin().equals(pin)) {
            model.addAttribute("error", "Invalid PIN");
            return "deposit";
        }

        // Add money
        account.setBalance(account.getBalance() + amount);

        // Save to DB
        accountRepository.save(account);

        model.addAttribute("success", "Deposit Successful!");
        model.addAttribute("balance", account.getBalance());

        return "deposit";
    }
}