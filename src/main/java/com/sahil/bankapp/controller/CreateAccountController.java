package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class CreateAccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/create")
    public String showCreatePage() {
        return "create";
    }

    @PostMapping("/create")
    public String createAccount(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String pin,
                                Model model) {

        Account account = new Account();

        Long accNo = ThreadLocalRandom.current()
                .longs(100000000000L, 999999999999L)
                .findFirst()
                .getAsLong();

        account.setAccountNumber(accNo);
        account.setName(name);
        account.setEmail(email);
        account.setPin(pin);
        account.setBalance(0.0);

        accountRepository.save(account);

        model.addAttribute("accountNumber", accNo);

        return "account-success";
    }
}