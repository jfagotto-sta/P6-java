package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.ContactService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;


    @Test
    public void getContacts() throws Exception {

//        User user1 = new User(1,"fagotto1","joffrey1","jfag@gmail.com","545454",80);
 //       User user2 = new User(1,"fagotto1","joffrey1","jf@gmail.com","12345",50);
//
//        ContactId contactId1 = new ContactId(user1,user2);
//        ContactId contactId2 = new ContactId(user1,user2);


 //       List<Contact> listOfContacts = new ArrayList<>();
//        Date date = new Date();

 //       Contact contact1 = new Contact(contactId1,date);
//
 //       listOfContacts.add(contact1);
//
//(contactService.getContacts()).thenReturn(listOfContacts);

   //     mockMvc.perform(get("/contact").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

    }

    @Test
    public void getContactsById() throws Exception {
        mockMvc.perform(get("/contact/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1"))
                .andExpect(status().isOk());
    }

    @Test
    public void delateUserUsingId() throws Exception {
        mockMvc.perform(delete("/contact/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1")).andExpect(status().isOk())
                .andExpect(status().isOk());
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
