package com.ncr.olbm.txns;

import com.ncr.olbm.Transactions.Transaction;
import com.ncr.olbm.Transactions.TransactionRepository;
import com.ncr.olbm.Transactions.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionService transactionService;

    private  TransactionService underTest;

    @BeforeEach
    void setUp() {
         underTest = new TransactionService(transactionRepository);
    }

    @Test
    public void TestsGetSortedTransactions(){
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
                "sgf195",
                "4567984623",
                "3892874569",
                1004.00,
                "Medical",
                "Success"
        );
        Transaction dummy4 = new Transaction(
                "sgf196",
                "4567984656",
                "3892874569",
                100.00,
                "Rent",
                "Success"
        );
        transactionRepository.saveAll(Arrays.asList(dummy1,dummy2,dummy3,dummy4));

        //When
        List<Transaction> list = underTest.getSortedTransactions("4567984623");

        //Then
        List<Transaction> got = Arrays.asList(dummy1,dummy2,dummy3);
        assertThat(got).usingRecursiveComparison().isEqualTo(list);
    }
}
