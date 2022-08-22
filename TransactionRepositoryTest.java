package com.ncr.olbm.txns;

import com.ncr.olbm.Transactions.Transaction;
import com.ncr.olbm.Transactions.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;
    @Test
    public  void testGetTransactionsForAccount(){
        //Given

        Transaction dummy1 =  new Transaction(
                "sgf190",
                "3892874568",
                "4567984623",
                5000.00,
                "Food",
                "Success"
        );
        Transaction dummy2 =  new Transaction(
                "sgf191",
                "3892874569",
                "4567984623",
                5004.00,
                "Food",
                "Success"
        );
        Transaction dummy3 = new Transaction(
                "sgf196",
                "4567984656",
                "3892874569",
                100.00,
                "Rent",
                "Success"
        );
        transactionRepository.saveAll(Arrays.asList(dummy1,dummy2,dummy3));

        //When
        List<Transaction> list = transactionRepository.findTransactionsByAcc("4567984623");

        //Then
        List<Transaction> got = Arrays.asList(dummy1,dummy2);
        assertThat(got).usingRecursiveComparison().isEqualTo(list);
    }
}
