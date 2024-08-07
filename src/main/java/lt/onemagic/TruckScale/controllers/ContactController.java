package lt.onemagic.TruckScale.controllers;

import lt.onemagic.TruckScale.models.Contact;
import lt.onemagic.TruckScale.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/id/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable long id) {
        Contact contact = contactService.getContactById(id);
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable long id) {
        try {
            contactService.deleteContactById(id);
            return ResponseEntity.noContent().build();
        } catch (DataAccessException ex) {
            // tvarkyti duomenų bazės klaidas
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Contact>> filterContacts(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String company) {
        List<Contact> filteredContacts = contactService.filterContacts(firstName, lastName, city, country, company);
        return ResponseEntity.ok(filteredContacts);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact contactDetails) {
        Contact updatedContact = contactService.updateContact(id, contactDetails);
        if (updatedContact != null) {
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
