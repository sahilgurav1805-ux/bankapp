package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PinChangeController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/pinchange")
    public String showPinPage() {
        return "pinchange";
    }

    @PostMapping("/pinchange")
    public String changePin(@RequestParam Long accountNumber,
                            @RequestParam String oldPin,
                            @RequestParam String newPin,
                            Model model) {

        Optional<Account> optionalAccount =
                accountRepository.findByAccountNumber(accountNumber);

        if (optionalAccount.isEmpty()) {
            model.addAttribute("message", "❌ Account not found");
            return "pinchange";
        }

        Account account = optionalAccount.get();

        if (account.getPin() == null || !account.getPin().equals(oldPin)) {
            model.addAttribute("message", "❌ Old PIN is incorrect");
            return "pinchange";
        }

        account.setPin(newPin);
        accountRepository.save(account);

        model.addAttribute("message", "✅ PIN changed successfully");
        return "pinchange";
    }
}