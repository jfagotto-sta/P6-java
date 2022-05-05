package com.OcProject.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping (path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public User createANewUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User findAUser (@RequestParam String mail) {
        return userService.getUserByMail(mail);
    }

//    @PutMapping (path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(code = HttpStatus.OK)
//    public boolean updateAUser (@RequestBody User user, @RequestParam long userId) {
//        return userService.updateAUser(user, userId);
//    }
//
//    @DeleteMapping (path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
//                produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(code = HttpStatus.OK)
//    public boolean deleteAUSer(@RequestParam long userId) {
//        return userService.deleteAUSer(userId);
//    }

}
