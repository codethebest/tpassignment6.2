package com.example.leo.tpassignment61.services.person;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.PersonContact;
import com.example.leo.tpassignment61.factories.person.PersonContactFactory;
import com.example.leo.tpassignment61.repository.person.PersonContactRepository;
import com.example.leo.tpassignment61.repository.person.impl.PersonContactRepositoryimpl;
import com.example.leo.tpassignment61.services.person.impl.PersonAddressServicesImpl;
import com.example.leo.tpassignment61.services.person.impl.PersonContactServiceimpl;

import junit.framework.Assert;

/**
 * Created by Leo on 5/8/2016.
 */
public class PersonContactServiceimplTest extends AndroidTestCase
{
    Intent intent;
    PersonContactRepository repo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new PersonContactRepositoryimpl(App.getAppContext());
    }

    public void testcreatePersonContact() throws Exception
    {
        intent = new Intent(App.getAppContext(), PersonContactServiceimpl.class);
        PersonContactService personContactService = new PersonContactServiceimpl();

        PersonContact personContact = new PersonContact.Builder()
                .mobile(7957813L)
                .email("leo.moko8@gmail.com")
                .website("www.google.com")
                .screenName("leo ROCKY")
                .build();

        personContactService.addPersonContact(App.getAppContext(),personContact);
        Assert.assertNotNull("Create",personContact);
    }

    public void testupdate()throws Exception
    {
        intent = new Intent(App.getAppContext(),PersonAddressServicesImpl.class);
        PersonContactService personContactService = new PersonContactServiceimpl();

        PersonContact updatePersonContac = new PersonContact.Builder()
                .mobile(7957813L)
                .email("leo.moko8@gmail.com")
                .website("www.google.com")
                .screenName("leo")
                .build();
        personContactService.updatePersonContact(App.getAppContext(),updatePersonContac);
        Assert.assertEquals("leo",updatePersonContac.getScreenName());
    }
}