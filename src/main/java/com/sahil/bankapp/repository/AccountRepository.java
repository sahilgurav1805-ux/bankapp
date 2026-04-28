package com.sahil.bankapp.repository;

import com.sahil.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByName(String name);

    Optional<Account> findByAccountNumber(Long accountNumber);

    Optional<Account> findByAccountNumberAndPin(Long accountNumber, String pin);
}