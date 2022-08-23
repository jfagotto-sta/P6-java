package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.*;
import com.OcProject.PayMyBuddy.services.ContactService;
import com.OcProject.PayMyBuddy.services.UserService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactServiceMock;

    @MockBean
    private UserService userService;

@Test
public void getAllContacts() throws Exception {

    List<Contact> listOfContacts = new ArrayList<>();



    when(contactServiceMock.getContacts()).thenReturn(listOfContacts);

    mockMvc.perform(get("/contacts")).andExpect(status().isOk());

}

@Test
public void newCOntact() throws Exception {

    ContactId contactId = new ContactId("a@a.net","b@b.net");

    Contact contact = new Contact();
    contact.setContactId(contactId);
    contact.setDate(new Date());

    ObjectMapper mapper = new ObjectMapper();
    String p =mapper.writeValueAsString(contact);

    when(contactServiceMock.addContact(contactId.getUser1(),contactId.getUser2())).thenReturn(contact);

    mockMvc.perform(post("/contact").contentType(MediaType.APPLICATION_JSON_VALUE).content(p))
            .andExpect(status().isOk());

}



    @Test
    public void deleteAUseFromFriends() throws Exception {


    ContactId contactId1 = new ContactId();
    contactId1.setUser1("a");
    contactId1.setUser2("a");

    Contact contact = new Contact();
    contact.setContactId(contactId1);
    contact.setDate(new Date());


    ObjectMapper mapper = new ObjectMapper();
    String p =mapper.writeValueAsString(contactId1);

     when(contactServiceMock.deleteById(contactId1)).thenReturn(true);

     mockMvc.perform(delete("/contact").contentType(MediaType.APPLICATION_JSON_VALUE).content(p))
                .andExpect(status().isOk());

    }

//    @Test
//    public void findContactWithId() throws Exception {
//
//        ContactId contactId1 = new ContactId();
//        contactId1.setUser1("a");
//        contactId1.setUser2("a");
//
//        Contact contact = new Contact();
//        contact.setContactId(contactId1);
//        contact.setDate(new Date());
//
//        when(contactServiceMock.getById(contactId1)).thenReturn(Optional.of(contact));
//
//        mockMvc.perform(get("/contact/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id", String.valueOf(contactId1)))
//                .andExpect(status().isOk());
//
//    }

}


