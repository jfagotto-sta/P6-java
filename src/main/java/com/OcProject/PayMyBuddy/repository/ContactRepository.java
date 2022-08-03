package com.OcProject.PayMyBuddy.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;

import java.util.List;


@Repository
public interface ContactRepository extends CrudRepository<Contact, ContactId>{

    @Query("SELECT c FROM Contact c WHERE (c.contactId.user1 = :mail1 and c.contactId.user2 = :mail2 ) " +
            "or (c.contactId.user1 = :mail2 and c.contactId.user2 = :mail1 )")
    public Contact findContactsFromMails(@Param("mail1") String mail1, @Param("mail2") String mail2);

    @Query("SELECT c FROM Contact c WHERE (c.contactId.user1 = :mail1 or c.contactId.user2 = :mail1 )")
    public List<Contact> findContactsAttachedToThisMail(@Param("mail1") String mail1);
}
