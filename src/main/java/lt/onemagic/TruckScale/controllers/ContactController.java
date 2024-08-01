package lt.onemagic.TruckScale.controllers;

import lt.onemagic.TruckScale.models.Contact;
import lt.onemagic.TruckScale.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        return ResponseEntity.ok(savedContact);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contactList = contactService.getAllContacts();
        return ResponseEntity.ok(contactList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable long id) {
        Contact contact = contactService.getContactById(id);
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
