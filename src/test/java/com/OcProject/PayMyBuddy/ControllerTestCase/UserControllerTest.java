package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.model.UserBean;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import com.OcProject.PayMyBuddy.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
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
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userServiceMock;




    @Test
    public void postAUser() throws Exception {
        UserBean user = new UserBean();

        ObjectMapper mapper = new ObjectMapper();
        String p =mapper.writeValueAsString(user);

        when(userServiceMock.newUser(user)).thenReturn(user);

        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(p))
                .andExpect(status().isOk());


    }

    @Test
    public void getUser() throws Exception {

       List<User> userList = new ArrayList<>();

        when(userServiceMock.getUsers()).thenReturn(userList);

        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());


    }


    @Test
    public void findUserByLastnameAndFirstName() throws Exception {

        List<User> listOfUsers = new ArrayList<>();
        User user1 = new User("fagotto1","joffrey1","jfag@gmail.com","545454",80);
        User user2 = new User("fagotto1","joffrey1","jf@gmail.com","12345",50);
        listOfUsers.add(user1);
        listOfUsers.add(user2);

        when(userServiceMock.findByLastNameAndFirstName("fagotto1","joffrey1")).thenReturn(user1);

        mockMvc.perform(get("/user/lastNameFirstName").contentType(MediaType.APPLICATION_JSON_VALUE).param("lastName","fagotto1").param("firstName","joffrey1"))
                .andExpect(status().isOk());
    }

    @Test
    public void findUserByLoggingInfos() throws Exception {


        User user1 = new User("fagotto1","joffrey1","jfag@gmail.com","545454",80);



        when(userServiceMock.findByMailAndPassword("jfag@gmail.com", "545454")).thenReturn(user1);

        mockMvc.perform(get("/login").contentType(MediaType.APPLICATION_JSON_VALUE).param("email","jfag@gmail.com").param("password","545454"))
                .andExpect(status().isOk());
    }

    @Test
    public void findUserByMail() throws Exception {
        User user = new User("fagotto","joffrey","jf@gmail.com","12345",50);

        when(userServiceMock.findByMail("jf@gmail.com"))
                .thenReturn(user);

        mockMvc.perform(get("/user/mail").contentType(MediaType.APPLICATION_JSON_VALUE).param("email","jf@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName").value("fagotto"));

    }

    @Test
    public void deleteUser() throws Exception {

        User user = new User();
        user.setMail("a@a.net");

        when(userServiceMock.delete(user.getMail())).thenReturn(true);

        mockMvc.perform(delete("/users").contentType(MediaType.APPLICATION_JSON_VALUE).param("userMail","a@a.net"))
                .andExpect(status().isOk());

    }

    @Test
    public void findMailWithLetters() throws Exception {

        List<User> userList = new ArrayList<>();

        User user = new User();
        user.setMail("a@a.net");

        userList.add(user);

        when(userServiceMock.findByLikableMail(user.getMail())).thenReturn(userList);

        mockMvc.perform(get("/users/contact").contentType(MediaType.APPLICATION_JSON_VALUE).param("email","a@a.net"))
                .andExpect(status().isOk());

    }


}
