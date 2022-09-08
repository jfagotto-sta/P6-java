package ServicesTest;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactBean;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.ContactRepository;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import com.OcProject.PayMyBuddy.services.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class ContactServiceTest {

    @Autowired
    ContactService contactService;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserRepository userRepository;


    public static Contact createAContact() {

        User sender = new User("toto","toto","t@t.net","ab",50f);
        User recipient = new User("tata","tata","h@h.net","ab",50f);

        ContactId contactId = new ContactId();
        contactId.setUser1(sender.getMail());
        contactId.setUser2(recipient.getMail());
        Contact contact = new Contact();
        contact.setContactId(contactId);
        contact.setDate(new Date());
        return contact;
    }

    @BeforeEach
    public void initialize() throws Exception {

        User sender = new User("toto","toto","t@t.net","ab",50f);
        User recipient = new User("tata","tata","h@h.net","ab",50f);

        contactRepository.deleteAll();
        userRepository.deleteAll();
        contactService.addContact(ContactServiceTest.createAContact().getContactId().getUser1(),ContactServiceTest.createAContact().getContactId().getUser2());
        userRepository.save(sender);
        userRepository.save(recipient);

    }

    @Test
    public void getcontacts() {

        List<Contact> listOfContacts = (List<Contact>) contactService.getContacts();
        assertTrue(listOfContacts.size()==1);
    }

    @Test
    public void deleteAContact(){


        ContactId contactId = new ContactId();
        contactId.setUser1("t@t.net");
        contactId.setUser2("h@h.net");

        contactService.deleteById(contactId);

        List<Contact> listOfContacts = (List<Contact>) contactService.getContacts();

        assertTrue(listOfContacts.size()==0);

    }

    @Test
    public void getCOntactById(){

        ContactId contactId = new ContactId();
        contactId.setUser1("t@t.net");
        contactId.setUser2("h@h.net");

        Optional<Contact> contact =  contactService.getById(contactId);

        assertNotNull(contact);

    }

    @Test
    public void findFriends(){



        List<ContactBean> contactBeans =  contactService.findFriends("t@t.net");

        assertTrue(contactBeans.size()==1);

    }

}
