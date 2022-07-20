package com.OcProject.PayMyBuddy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.UserService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping (path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public User createANewUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<User> getAllUsers () {
        return userService.getUsers();
    }

    @GetMapping(path = "/user/mail", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserByMail(@RequestParam String email) {
        return userService.findByMail(email);
    }

    //fonctionne avec un LIKE
    @GetMapping(path = "/users/contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<User> getUsersByMail(@RequestParam String email) {
        List<User> usersFilteredByMail = userService.findByLikableMail(email);
        for (User u : usersFilteredByMail) {
            u.setPassword(null);
            u.setBalance(null);
        }

        return usersFilteredByMail;
    }

    //SERVICE QUI GERE LA CONNEXION
    @GetMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserFromLogin(@RequestParam String email, @RequestParam String password) {
        return userService.findByMailAndPassword(email, password);
    }
    
    @GetMapping(path = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User getMessage() {
    	User u = new User();
    	u.setFirstName("test");
    	u.setLastName("michel");
    	u.setBalance(18d);
    	return u;
    }
    
    
    @GetMapping(path = "/user/lastNameFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getUserByMail(@RequestParam String lastName, @RequestParam String firstName) {
        return userService.findByLastNameAndFirstName(lastName, firstName);
    }

    @GetMapping(path = "/user/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<User> getUserById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping (path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAUSer(@RequestParam int userId) {
       userService.deleteById(userId);
    }



}
