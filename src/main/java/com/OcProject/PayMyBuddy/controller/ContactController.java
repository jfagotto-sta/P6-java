package com.OcProject.PayMyBuddy.controller;

import com.OcProject.PayMyBuddy.exceptions.CreateException;
import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactBean;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ContactController {

    @Autowired
    private ContactService contactService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @PostMapping (path = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public Contact createANewContact(@RequestBody ContactId contactId) throws Exception {
        logger.info("Nouveau contact créé");
        return contactService.addContact(contactId.getUser1(), contactId.getUser2());
    }

    @GetMapping(path = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Contact> getAllContacts () {
        logger.info("Liste complète des contacts chargée");
        return contactService.getContacts();
    }



    @GetMapping(path = "/contact/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Contact> getContactById(@RequestParam ContactId id) {
        logger.info("Contact chargé");
        return contactService.getById(id);
    }

    @GetMapping(path = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<ContactBean> findContactWithMail(@RequestParam String mail) {
        logger.info("Contact chargé pour l'utilisateur avec le mail "+mail);
        return contactService.findFriends(mail);
    }


    @DeleteMapping (path = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public boolean deleteAUSer(@RequestBody ContactId contactBean) {
        Optional<Contact> exist = contactService.getById(contactBean);
        String mail1 = contactBean.getUser1();
        String mail2 = contactBean.getUser2();
        if(!exist.isPresent()) {
            contactBean = new ContactId();
            contactBean.setUser1(mail2);
            contactBean.setUser2(mail1);
        }
        contactService.deleteById(contactBean);
        logger.info("contact supprimé");
        return true;
    }

}