package lt.onemagic.TruckScale.services;

import lombok.Data;
import lt.onemagic.TruckScale.models.Contact;
import lt.onemagic.TruckScale.repositories.ContactRepository;
//import lt.onemagic.TruckScale.utils.ContactDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.ArrayList;

@Data
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public void deleteContactById(long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> filterContacts(String firstName, String lastName, String city, String country, String company) {
        return contactRepository.filterContacts(firstName, lastName, city, country, company);
    }

    public Contact updateContact(long id, Contact contactDetails) {
        return contactRepository.findById(id)
                .map(existingContact -> {
                    existingContact.updateDetails(contactDetails);
                    return contactRepository.save(existingContact);
                })
                .orElse(null);
    }

//    public void generateAndSaveContacts(int count) {
//        List<Contact> contacts = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            contacts.add(ContactDataGenerator.generateContact());
//        }
//        contactRepository.saveAll(contacts);
//    }

}