package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getTransactionEndpoint() throws Exception {
        mockMvc.perform(get("/transaction")).andExpect(status().isOk());

    }

    @Test
    public void getTransactionWithId() throws Exception {
        mockMvc.perform(get("/user/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTransactionUsingId() throws Exception {
        mockMvc.perform(delete("/transaction/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1")).andExpect(status().isOk())               .andExpect(status().isOk());
    }

}
