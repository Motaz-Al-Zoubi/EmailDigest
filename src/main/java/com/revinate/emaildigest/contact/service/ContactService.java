package com.revinate.emaildigest.contact.service;

import com.github.javafaker.Faker;
import com.revinate.emaildigest.contact.model.Contact;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class ContactService {
    static final int TOTAL_NB_CONTACTS = 12345;
    private final List<Contact> contactList;

    public ContactService() {
        contactList = generateContacts();
    }

    private static List<Contact> generateContacts() {
        var contacts = new ArrayList<Contact>(TOTAL_NB_CONTACTS);
        var faker = new Faker();
        IntStream.range(0, TOTAL_NB_CONTACTS).forEach(i -> contacts.add(new Contact()
            .setEmail(faker.internet().emailAddress())
            .setFirstName(faker.name().firstName())
            .setLastName(faker.name().lastName()))
        );
        return contacts;
    }

    public Iterator<List<Contact>> getPaginatedContacts(int pageSize) {
        List<List<Contact>> partitionedContacts = ListUtils.partition(contactList, pageSize);
        return partitionedContacts.iterator();
    }
}
