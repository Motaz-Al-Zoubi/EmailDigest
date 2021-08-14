package com.revinate.emaildigest.digest.service;

import java.util.List;

import com.revinate.emaildigest.contact.model.Contact;
import com.revinate.emaildigest.contact.service.ContactService;
import com.revinate.emaildigest.deal.model.Deal;
import com.revinate.emaildigest.deal.service.DealService;
import com.revinate.emaildigest.digest.model.Digest;
import com.revinate.emaildigest.email.model.Email;
import com.revinate.emaildigest.email.service.EmailService;
import com.revinate.emaildigest.templateEngine.service.TemplateCompiler;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class PeriodicDigest {
    static final int PAGE_SIZE = 1000;

    @Autowired
    private ContactService contactService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateCompiler compiler;

    @Autowired
    protected DealService dealService;

    public void send() {
        String emailSubject = getEmailSubject();
        String title = getEmailTitle();

        try {
            var pagesIterator =  contactService.getPaginatedContacts(PAGE_SIZE);
            while (pagesIterator.hasNext()) {
                List<Contact> contactsPage = pagesIterator.next();
                for (Contact contact : contactsPage) {
                    List<Deal> deals = getDealsByEmail(contact.getEmail());
                    Digest digest = new Digest(title, contact, deals);
                    String emailBody = compiler.compile("templates/digest.mustache", digest);
                    Email email = new Email(emailSubject, emailBody);
                    emailService.sendEmail(email, contact.getEmail());
                }
            }
        } catch (Exception e) {
            log.error("Error while trying to send the digests", e);
        }
    }

    protected abstract String getEmailTitle();

    protected abstract String getEmailSubject();

    protected abstract List<Deal> getDealsByEmail(String email);
}
