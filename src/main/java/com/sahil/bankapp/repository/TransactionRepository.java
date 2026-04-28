package com.sahil.bankapp.repository;

import com.sahil.bankapp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByAccountNumber(long accountNumber);
}