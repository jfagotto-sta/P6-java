package com.OcProject.PayMyBuddy.controller;

import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.OcProject.PayMyBuddy.model.User;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @PostMapping (path = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Contact createANewUser(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @GetMapping(path = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Contact> getAllContacts () {
        return contactService.getContacts();
    }

    @GetMapping(path = "/contact/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Contact> getContactById(@RequestParam ContactId id) {
        return contactService.getById(id);
    }


    @DeleteMapping (path = "/contact/id", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteAUSer(@RequestParam ContactId contactId) {
        contactService.deleteById(contactId);
    }

}