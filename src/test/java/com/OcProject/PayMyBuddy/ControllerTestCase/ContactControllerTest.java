package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.Contact;
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
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getContacts() throws Exception {
        mockMvc.perform(get("/contact")).andExpect(status().isOk());

    }

    @Test
    public void getContactsById() throws Exception {
        mockMvc.perform(get("/contact/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1"))
                .andExpect(status().isOk());
    }

    @Test
    public void delateUserUsingId() throws Exception {
        mockMvc.perform(delete("/contact/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1")).andExpect(status().isOk())               .andExpect(status().isOk());
    }


//    @Test
//    public void postUser() throws Exception {
//
//        Contact contact = new Contact();
//        contact.setContactId(1);
//        contact.setDate("18/07/1993");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String u = objectMapper.writeValueAsString(contact);
//
//
//        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(String.valueOf(u)))
//                .andExpect(status().isOk());
//    }
}
