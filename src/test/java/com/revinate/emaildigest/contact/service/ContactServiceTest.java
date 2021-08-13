package com.revinate.emaildigest.contact.service;

import com.revinate.emaildigest.contact.model.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {
    private static final int PAGE_SIZE = 1000;
    @InjectMocks
    private ContactService contactService;

    @Test
    void getPaginatedContacts() {
        var paginatedContacts = contactService.getPaginatedContacts(PAGE_SIZE);

        int totalContacts = 0;
        while(paginatedContacts.hasNext()) {
            List<Contact> contacts = paginatedContacts.next();
            assertContacts(contacts);
            if (paginatedContacts.hasNext()) {
                assertEquals(PAGE_SIZE, contacts.size());
            } else {
                assertTrue(PAGE_SIZE >= contacts.size());
            }
            totalContacts += contacts.size();
        }
        assertEquals(ContactService.TOTAL_NB_CONTACTS, totalContacts);
    }


    private void assertContacts(List<Contact> contacts) {
        contacts.forEach(this::assertContact);
    }

    private void assertContact(Contact contact) {
        assertFalse(contact.getFirstName().isEmpty());
        assertFalse(contact.getLastName().isEmpty());
        assertFalse(contact.getEmail().isEmpty());
    }
}