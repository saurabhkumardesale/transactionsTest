package com.ncr.olbm.Transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,String>{
    @Query("SELECT t FROM Transaction t WHERE t.toAcc=:toAcc OR t.fromAcc=:toAcc")
    List<Transaction> findTransactionsByAcc(String toAcc);
}