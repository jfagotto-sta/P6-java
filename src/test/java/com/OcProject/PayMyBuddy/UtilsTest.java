package com.OcProject.PayMyBuddy;

import com.OcProject.PayMyBuddy.utils.TransactionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UtilsTest {


    @Test
    public void feesCalculatorTest(){

        double transactionAmount = 100;
        double fees = TransactionUtils.calculateFess(transactionAmount);

        assertTrue(fees == 100*0.05);
    }
}
