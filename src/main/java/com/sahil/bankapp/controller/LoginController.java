package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.repository.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // matches your login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam Long accountNumber,
                        @RequestParam String pin,
                        HttpSession session,
                        Model model) {

        Optional<Account> accOpt = accountRepository.findByAccountNumber(accountNumber);

        if (accOpt.isEmpty()) {
            model.addAttribute("error", "Account not found");
            return "login";
        }

        Account account = accOpt.get();

        if (account.getPin() == null || !account.getPin().equals(pin)) {
            model.addAttribute("error", "Invalid PIN");
            return "login";
        }

        // store session (VERY IMPORTANT)
        session.setAttribute("account", account);

        return "redirect:/dashboard";
    }
}