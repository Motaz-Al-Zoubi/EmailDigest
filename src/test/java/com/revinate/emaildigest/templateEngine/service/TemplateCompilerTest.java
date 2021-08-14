package com.revinate.emaildigest.templateEngine.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.revinate.emaildigest.contact.model.Contact;

public class TemplateCompilerTest {

    private TemplateCompiler templateCompiler = new TemplateCompiler();

    @Test
    void shouldReplaceVariableWithValue() throws Exception {
        class Scope {
            private Contact contact;
            public Scope(Contact contact) {
                this.contact = contact;
            }
            public Contact getContact() {
                return this.contact;
            }
        }
        var scope = new Scope(new Contact());
        scope.getContact().setFirstName("Motaz");
        var greeting = templateCompiler.compile("templates/greeting.mustache", scope);
        assertTrue(greeting.contains("Motaz"));
    }

}
