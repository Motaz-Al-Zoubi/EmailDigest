package com.revinate.emaildigest.templateEngine.service;

import java.io.IOException;
import java.io.StringWriter;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import org.springframework.stereotype.Component;

@Component
public class TemplateCompiler {

    public String compile(String resourceName, Object scope) throws IOException {
        MustacheFactory mustacheFactory = new DefaultMustacheFactory();
        Mustache mustache = mustacheFactory.compile(resourceName);

        StringWriter writer = new StringWriter();
        mustache.execute(writer, scope).flush();
        return writer.toString();
    }
}
