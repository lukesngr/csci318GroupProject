package csci318.parta.controller;

import csci318.parta.repository.ContactRepository;
import csci318.parta.model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactRepository contactRepository;

    ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contact")
    List<Contact> findAllContact() {
        return contactRepository.findAll();
    }

    @GetMapping("/contact/{id}")
    Contact getContactById(@PathVariable Long id) {
        return contactRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/contact")
    Contact createCustomer(@RequestBody Contact newContact) {
        return contactRepository.save(newContact);
    }

}
