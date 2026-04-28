package com.sahil.bankapp.controller;

import com.sahil.bankapp.entity.Transaction;
import com.sahil.bankapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/transactions")
    public String showPage() {
        return "transactions";
    }

    @PostMapping("/transactions")
    public String getTransactions(@RequestParam Long accountNumber,
                                  Model model) {

        List<Transaction> list =
                transactionRepository.findByAccountNumber(accountNumber);

        if (list.isEmpty()) {
            model.addAttribute("error", "No transactions found");
            return "transactions";
        }

        model.addAttribute("transactions", list);

        return "transactions";
    }
}