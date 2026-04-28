package com.sahil.bankapp.service;

import com.sahil.bankapp.entity.Account;
import com.sahil.bankapp.entity.Transaction;
import com.sahil.bankapp.repository.AccountRepository;
import com.sahil.bankapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServices {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // DEPOSIT
    public String deposit(long accountNumber, double amount) {

        Optional<Account> optional = accountRepository.findByAccountNumber(accountNumber);

        if (optional.isPresent()) {

            Account account = optional.get();
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);

            transactionRepository.save(
                    new Transaction(accountNumber, "DEPOSIT", amount, account.getBalance())
            );

            return "Deposit successful";
        }

        return "Account not found";
    }

    // WITHDRAW
    public String withdraw(long accountNumber, double amount) {

        Optional<Account> optional = accountRepository.findByAccountNumber(accountNumber);

        if (optional.isPresent()) {

            Account account = optional.get();

            if (account.getBalance() >= amount) {

                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);

                transactionRepository.save(
                        new Transaction(accountNumber, "WITHDRAW", amount, account.getBalance())
                );

                return "Withdraw successful";
            }

            return "Insufficient balance";
        }

        return "Account not found";
    }

    // BALANCE
    public String checkBalance(long accountNumber) {

        Optional<Account> optional = accountRepository.findByAccountNumber(accountNumber);

        if (optional.isPresent()) {
            return "Balance: " + optional.get().getBalance();
        }

        return "Account not found";
    }
    public String createAccount(String name, long accountNumber, double balance) {

        Account account = new Account();
        account.setName(name);
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);

        accountRepository.save(account);

        return "Account created successfully with A/C: " + accountNumber;
    }

    // MINI STATEMENT
    public List<Transaction> getMiniStatement(long accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    // PIN CHANGE
    public String changePin(long accountNumber, String oldPin, String newPin) {

        Optional<Account> optional = accountRepository.findByAccountNumber(accountNumber);

        if (optional.isPresent()) {

            Account account = optional.get();

            if (account.getPin().equals(oldPin)) {
                account.setPin(newPin);
                accountRepository.save(account);
                return "PIN changed successfully";
            }

            return "Old PIN incorrect";
        }

        return "Account not found";
    }
}