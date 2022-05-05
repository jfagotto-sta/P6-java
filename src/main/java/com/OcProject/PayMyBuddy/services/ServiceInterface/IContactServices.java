//package com.OcProject.PayMyBuddy.services.ServiceInterface;
//
//import com.OcProject.PayMyBuddy.model.Contact;
//import com.OcProject.PayMyBuddy.model.ContactId;
//import com.OcProject.PayMyBuddy.model.User;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public interface IContactServices {
//
//    public List<User> findAllContactsByUser(User user);
//
//    public <S extends Contact> S save(S entity);
//
//    public <S extends Contact> Iterable<S> saveAll(Iterable<S> entities);
//
//    public Optional<Contact> findById(ContactId contactId);
//
//    public boolean existsById(ContactId contactId);
//
//
//    public Iterable<Contact> findAll();
//
//    public Iterable<Contact> findAllById(Iterable<ContactId> contactIds);
//
//
//    public long count();
//
//
//    public void deleteById(ContactId contactId);
//
//
//    public void delete(Contact entity);
//
//
//    public void deleteAllById(Iterable<? extends ContactId> contactIds);
//
//    public void deleteAll(Iterable<? extends Contact> entities);
//
//    public void deleteAll();
//}
