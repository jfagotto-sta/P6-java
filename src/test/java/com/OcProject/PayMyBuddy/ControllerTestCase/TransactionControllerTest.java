package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;


    @Test
    public void postATransaction() {
        User user1 = new User();
        User user2 = new User();


        Transaction transaction = new Transaction();
        transaction.setFees(1);
        transaction.setDateOfTransaction(new Date());
        transaction.setIdTransaction(1);
        transaction.setSender(user1);
        transaction.setRecipient(user2);
        transaction.setAmount(500);

        when(transactionService.newTransaction(transaction)).thenReturn(transaction);

        ObjectMapper objectMapper = new ObjectMapper();
        String p = null;
        try {
            p = objectMapper.writeValueAsString(transaction);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            mockMvc.perform(post("/transaction").contentType(MediaType.APPLICATION_JSON_VALUE).content(p))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTransactions() throws Exception {

        List<Transaction> list = new ArrayList<>();

        Date date = new Date();
        User user1 = new User();
        User user2 = new User();
        Transaction transaction = new Transaction(1,50,date,user1,user2,50);
        list.add(transaction);

        when(transactionService.getTransactions()).thenReturn(list);

        mockMvc.perform(get("/transaction").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    public void getTransactionById() throws Exception {

        Date date = new Date();
        User user1 = new User();
        User user2 = new User();
        Transaction transaction = new Transaction(1,50,date,user1,user2,50);

        when(transactionService.getTransactionById(1)).thenReturn(Optional.of(transaction));

        mockMvc.perform(get("/transaction/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(50));
    }

//    @Test
//    public void deleteTransactionById() throws Exception {
//
//        Date date = new Date();
//        User user1 = new User();
//        User user2 = new User();
//        Transaction transaction = new Transaction(1,50,date,user1,user2,50);
//
//        when(transactionService.deleteById(1)).thenReturn(Optional.of(transaction));
//
//        mockMvc.perform(get("/transaction/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.amount").value(50));
//    }

}
