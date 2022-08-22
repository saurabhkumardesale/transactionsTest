package com.ncr.olbm.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

   /* public List<Transaction> getTransactions(String toAcc) {
        List<Transaction> transactionList = transactionRepository.findTransactionsByAcc(toAcc);
            return  transactionList;
    }*/

    public List<Transaction> getSortedTransactions(String toAcc) {
        List<Transaction> sortedTransactionList = transactionRepository.findTransactionsByAcc(toAcc);
        sortedTransactionList.sort((o1,o2) -> o1.getTime().compareTo(o2.getTime()));
        return  sortedTransactionList;
    }


}
