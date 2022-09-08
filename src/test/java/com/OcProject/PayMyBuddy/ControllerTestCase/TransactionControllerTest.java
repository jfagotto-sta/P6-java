package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.TransactionBean;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.TransactionService;
import com.OcProject.PayMyBuddy.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;


    @Test
    public void postNewTransaction() throws Exception {

        TransactionBean transactionBean = new TransactionBean();
        transactionBean.setAmount(50);
        transactionBean.setSender("a@a.net");
        transactionBean.setRecipient("b@b.net");

        double feesBeforeTransaction = userService.findByMail("admin@admin.fr").getBalance();

        ObjectMapper objectMapper = new ObjectMapper();
        String p = objectMapper.writeValueAsString(transactionBean);

        when(transactionService.makeATransaction(transactionBean)).thenReturn(transactionBean);

        mockMvc.perform(post("/transaction").contentType(MediaType.APPLICATION_JSON).content(p))
                .andExpect(status().isOk());

    //    assertNotEquals(userService.findByMail("admin@admin.fr").getBalance(), feesBeforeTransaction);
    }

    @Test
    public void getTransactions() throws Exception {

        List<Transaction> list = new ArrayList<>();

        Date date = new Date();
        User user1 = new User();
        String mailUser = user1.getMail();


        when(transactionService.getTransactions()).thenReturn(list);

        mockMvc.perform(get("/transactions").contentType(MediaType.APPLICATION_JSON_VALUE).param("email","mailUser"))
                .andExpect(status().isOk());

    }

    @Test
    public void getTransaction() throws Exception {

        Iterable<TransactionBean> list = new ArrayList<>();

        Date date = new Date();
        User user1 = new User();
        String mailUser = user1.getMail();


        when(transactionService.getTransactionList(mailUser)).thenReturn(list);

        mockMvc.perform(get("/transaction").contentType(MediaType.APPLICATION_JSON_VALUE).param("email","mailUser"))
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
