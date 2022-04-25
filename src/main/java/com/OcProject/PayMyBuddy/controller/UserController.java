//package com.OcProject.PayMyBuddy.controller;
//
//import com.OcProject.PayMyBuddy.model.User;
//import com.OcProject.PayMyBuddy.services.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class UserController {
//
//    private UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @PostMapping (path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(code = HttpStatus.OK)
//    public User createANewUser(@RequestBody User user) {
//        return userService.createANewUser(user);
//    }
//
//    @GetMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(code = HttpStatus.OK)
//    public User findAUser (@RequestParam long userId) {
//        return userService.findAUser(userId);
//    }
//
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
//
//}
