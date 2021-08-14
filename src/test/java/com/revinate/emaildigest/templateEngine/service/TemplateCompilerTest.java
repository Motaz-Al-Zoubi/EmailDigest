package com.revinate.emaildigest.templateEngine.service;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import static org.junit.jupiter.api.Assertions.*;

import com.revinate.emaildigest.contact.model.Contact;


@AllArgsConstructor
@Data
class Scope {
    private Contact contact;
}

public class TemplateCompilerTest {

    private TemplateCompiler templateCompiler = new TemplateCompiler();

    @Test
    void shouldReplaceVariableWithValue() throws Exception {
        var scope = new Scope(new Contact());
        scope.getContact().setFirstName("Motaz");
        var greeting = templateCompiler.compile("templates/greeting.mustache", scope);
        assertTrue(greeting.contains("Motaz"));
    }

}
