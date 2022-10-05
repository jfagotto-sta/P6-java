package com.OcProject.PayMyBuddy.ServicesTest;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.model.UserBean;
import com.OcProject.PayMyBuddy.repository.TransactionRepository;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import com.OcProject.PayMyBuddy.services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public static UserBean  createUser() {
        UserBean userBean = new UserBean();
        userBean.setFirstName("fag");
        userBean.setLastName("fagggggggg");
        userBean.setEmail("13@1.net");
        userBean.setPassword("ab");
        return userBean;
    }


    @BeforeEach
    public void initialize() {
        transactionRepository.deleteAll();
        userRepository.deleteAll();
        userService.newUser(UserServiceTest.createUser());
    }

    @AfterEach
    public void clean() {
        userRepository.deleteAll();
    }

    @Test
    public void newUserTest(){
        UserBean userBean = new UserBean();
        userBean.setFirstName("fag");
        userBean.setLastName("fagggggggg");
        userBean.setEmail("bidule.net");
        userBean.setPassword("ab");
        userService.newUser(userBean);
        User u = userService.findByMail("bidule.net");
        assertNotNull(u);


    }

    @Test
    public void findLikableMail(){
        List<User> user =  userService.findByLikableMail("13");
        assertNotNull(user);
    }

    @Test
    public void testSave(){
        User user =  userService.findByLastNameAndFirstName("fagggggggg", "fag");
        assertTrue(user.getBalance()!=1000);
        user.setBalance(1000d);
        userService.save(user);
        user =  userService.findByLastNameAndFirstName("fagggggggg", "fag");
        assertTrue(user.getBalance()==1000);
    }
    @Test
    public void findByLastNameAndFirstName(){

        User user =  userService.findByLastNameAndFirstName("fagggggggg", "fag");
        assertNotNull(user);
    }

    @Test
    public void getUsers(){

        List<User> list = (List<User>) userService.getUsers();
        assertTrue(list.size() == 1);
        assertNotNull(list);
    }

    @Test
    public void findByMailAndPassword(){

         User user = userService.findByMailAndPassword("13@1.net","ab");
        assertNotNull(user);

    }

    @Test
    public void deleteUserTest(){

        userService.delete("13@1.net");

        List<User> list1 = (List<User>) userService.getUsers();

       assertTrue(list1.size()==0);

    }
}
