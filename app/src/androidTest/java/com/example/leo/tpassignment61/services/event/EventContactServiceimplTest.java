package com.example.leo.tpassignment61.services.event;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventContact;
import com.example.leo.tpassignment61.factories.event.EventContactFactory;
import com.example.leo.tpassignment61.repository.event.EventContactRepository;
import com.example.leo.tpassignment61.repository.event.impl.EventContactRepositoryimpl;
import com.example.leo.tpassignment61.services.event.impl.EventContactServiceimpl;

import org.junit.Assert;

import javax.crypto.ExemptionMechanismException;
import java.util.*;
/**
 * Created by Leo on 5/8/2016.
 */
public class EventContactServiceimplTest extends AndroidTestCase{
    Intent intent;
    EventContactRepository repo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new EventContactRepositoryimpl(App.getAppContext());
    }

    public void testcreateEventContact() throws Exception
    {
        intent = new Intent(App.getAppContext(), EventContactServiceimpl.class);
        EventContactService eventContactService = new EventContactServiceimpl();

        EventContact eventContact = new EventContact.Builder()
                .phone("086333542")
                .email("leo.moko8@gmail.com")
                .website("www.google.com")
                .build();

        eventContactService.addEventContact(App.getAppContext(), eventContact);
        Assert.assertNotNull("Create", eventContact);

        Set<EventContact> eventContacts = repo.readAll();
        Assert.assertEquals(10, eventContacts.size());
    }
}
