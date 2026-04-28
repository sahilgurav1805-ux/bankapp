package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class WithdrawController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/withdraw")
    public String showWithdrawPage() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawMoney(@RequestParam Long accountNumber,
                                @RequestParam String pin,
                                @RequestParam double amount,
                                Model model) {

        Optional<Account> accOpt = accountRepository.findByAccountNumber(accountNumber);

        if (accOpt.isEmpty()) {
            model.addAttribute("error", "Account not found");
            return "withdraw";
        }

        Account account = accOpt.get();

        // PIN check
        if (account.getPin() == null || !account.getPin().equals(pin)) {
            model.addAttribute("error", "Invalid PIN");
            return "withdraw";
        }

        // Balance check
        if (account.getBalance() < amount) {
            model.addAttribute("error", "Insufficient Balance");
            return "withdraw";
        }

        // Deduct money
        account.setBalance(account.getBalance() - amount);

        // Save to DB
        accountRepository.save(account);

        model.addAttribute("success", "Withdrawal Successful!");
        model.addAttribute("balance", account.getBalance());

        return "withdraw";
    }
}