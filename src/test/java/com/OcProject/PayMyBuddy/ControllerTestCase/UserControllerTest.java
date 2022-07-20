package com.OcProject.PayMyBuddy.ControllerTestCase;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.UserService;
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
        User user = new User("fagotto","joffrey","jf@gmail.com","12345",50);

        ObjectMapper mapper = new ObjectMapper();
        String p =mapper.writeValueAsString(user);

        when(userServiceMock.newUser(user)).thenReturn(user);

        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(p))
                .andExpect(status().isOk());


    }

    @Test
    public void findUserById() throws Exception {
        User user1 = new User("fagotto","joffrey","jf@gmail.com","12345",50);

        when(userServiceMock.getUserById(1)).thenReturn(Optional.of(user1));

        mockMvc.perform(get("/user/id").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName").value("fagotto"));
    }

    @Test
    public void findAllUsers() throws Exception {

        List<User> listOfUsers = new ArrayList<>();
        User user1 = new User("fagotto1","joffrey1","jfag@gmail.com","545454",80);
        User user2 = new User("fagotto1","joffrey1","jf@gmail.com","12345",50);
        listOfUsers.add(user1);
        listOfUsers.add(user2);

        when(userServiceMock.getUsers()).thenReturn(listOfUsers);

        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

    }

    @Test
    public void findUserByLastnameAndFirstName() throws Exception {

        List<User> listOfUsers = new ArrayList<>();
        User user1 = new User("fagotto1","joffrey1","jfag@gmail.com","545454",80);
        User user2 = new User("fagotto1","joffrey1","jf@gmail.com","12345",50);
        listOfUsers.add(user1);
        listOfUsers.add(user2);

        when(userServiceMock.findByLastNameAndFirstName("fagotto1", "jfag@gmail.com"))
                .thenReturn(listOfUsers);

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



}
