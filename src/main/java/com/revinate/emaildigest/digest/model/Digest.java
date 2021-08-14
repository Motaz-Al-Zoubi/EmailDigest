package com.revinate.emaildigest.digest.model;

import java.util.List;

import com.revinate.emaildigest.contact.model.Contact;
import com.revinate.emaildigest.deal.model.Deal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Digest {
    String title;
    Contact contact;
    List<Deal> deals;
}
