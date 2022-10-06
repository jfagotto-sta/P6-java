package com.OcProject.PayMyBuddy.controller;

import java.util.List;

import com.OcProject.PayMyBuddy.model.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @PostMapping (path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void createANewUser(@RequestBody UserBean user) {
        logger.info("Nouvel utilisateur enregistré");
        userService.newUser(user);
    }

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<User> getAllUsers () {
        logger.info("Liste des utilisateurs chargée");
        return userService.getUsers();
    }

    @GetMapping(path = "/user/mail", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserByMail(@RequestParam String email) {
        logger.info("Utilisateur trouvé avec le mail "+email);
        return userService.findByMail(email);
    }

    //fonctionne avec un LIKE
    @GetMapping(path = "/users/contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<User> getUsersByMail(@RequestParam String email) {
        List<User> usersFilteredByMail = userService.findByLikableMail(email);
        User doublon = null;
        for (User u : usersFilteredByMail) {
            u.setPassword(null);
            u.setBalance(null);
            if(u.getMail().equals(email)) {
                doublon = u;
            }
        }
        usersFilteredByMail.remove(doublon);
        logger.info("Utilisateurs chargé");
        return usersFilteredByMail;
    }

    //SERVICE QUI GERE LA CONNEXION
    @GetMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserFromLogin(@RequestParam String email, @RequestParam String password) {
       logger.info("Utilisateurs lié au mail "+email+" connecté");
       return userService.findByMailAndPassword(email, password);

    }

    
    @GetMapping(path = "/user/lastNameFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserByMail(@RequestParam String lastName, @RequestParam String firstName) {
        logger.info("Utilisateur "+lastName+""+firstName+" chargé");
        return userService.findByLastNameAndFirstName(lastName, firstName);
    }


    @DeleteMapping (path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Boolean deleteAUSer(@RequestParam String userMail) {
        logger.info("Utilisateur supprimé");
       userService.delete(userMail);
        return true;
    }

    @PostMapping(path = "/user/addmoney", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void addMoney(@RequestParam String mail, @RequestParam Double montant) {
        logger.info("L'utilisateur avec le mail "+mail+" a ajouté "+montant+" sur son compte PMB");
        userService.addMoney(mail,montant);
    }

    @PostMapping(path = "/user/pulloffmoney", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void pullOffMoney(@RequestParam String mail, @RequestParam Double montant) {
        logger.info("L'utilisateur avec le mail "+mail+" a retiré "+montant+" sur son compte PMB");
        userService.pullOfMoney(mail,montant);
    }



}
