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
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Test pour controler l'endpoint /user")
    public void getUserEndpoint() throws Exception {
        mockMvc.perform(get("/user")).andExpect(status().isOk());

    }

    @Test
    @DisplayName("Test pour controler l'endpoint /user/mail")
    public void getUserByMail() throws Exception {
        mockMvc.perform(get("/user/mail").contentType(MediaType.APPLICATION_JSON_VALUE).param("email","a@a.fr"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test pour controler l'endpoint /user/lastNameFirstName")
    public void getUserBylastNameAndFirstName() throws Exception {
        mockMvc.perform(get("/user/lastNameFirstName").contentType(MediaType.APPLICATION_JSON_VALUE).param("lastName","toto").param("firstName","titi"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test pour controler l'endpoint /user/id")
    public void getUserById() throws Exception {
        mockMvc.perform(get("/user/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1"))
                .andExpect(status().isOk());
    }

    @Test
    public void postUser() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setPassword("ab");
        user.setMail("j@j.net");
        user.setLastName("toto");
        user.setFirstName("titi");
        user.setBalance(30.5);

        ObjectMapper objectMapper = new ObjectMapper();
        String u = objectMapper.writeValueAsString(user);


        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(String.valueOf(u)))
                .andExpect(status().isOk());
    }

}
