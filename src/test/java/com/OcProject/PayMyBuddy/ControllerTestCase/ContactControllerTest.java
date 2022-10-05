package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.*;
import com.OcProject.PayMyBuddy.services.ContactService;
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



    @Test
    public void findContactWithMail() throws Exception {

        ContactId contactId1 = new ContactId();
        contactId1.setUser1("b@b.net");
        contactId1.setUser2("a@a.net");

        Contact contact = new Contact();
        contact.setContactId(contactId1);
        contact.setDate(new Date());

        List<ContactBean> contactBeans = new ArrayList<>();

        User u = new User();
        u.setMail("a@a.net");
        u.setBalance(50d);
        u.setPassword("ab");
        u.setFirstName("jrff");
        u.setLastName("goto");


        ContactBean contactBean = new ContactBean();
        contactBean.setFriendsSince(String.valueOf(new Date()));
        contactBean.setMail(u.getMail());
        contactBean.setLastName(u.getLastName());
        contactBean.setFirstName(u.getFirstName());

        contactBeans.add(contactBean);


        when(contactServiceMock.findFriends(contactId1.getUser2())).thenReturn(contactBeans);

        mockMvc.perform(get("/contact").contentType(MediaType.APPLICATION_JSON_VALUE).param("mail", "a@a.net"))
                .andExpect(status().isOk());
    }

    @Test
    public void getContactById() throws Exception {


        ContactId contactId1 = new ContactId();
        contactId1.setUser1("a");
        contactId1.setUser2("b");

        Contact contact = new Contact();
        contact.setContactId(contactId1);
        contact.setDate(new Date());


        ObjectMapper mapper = new ObjectMapper();
        String c = mapper.writeValueAsString(contactId1);
        System.out.println(c);

        when(contactServiceMock.getById(contactId1)).thenReturn(Optional.of(contact));

        mockMvc.perform(get("/contact/id").contentType(MediaType.APPLICATION_JSON_VALUE).content(c))
                .andExpect(status().isOk());

    }


}


