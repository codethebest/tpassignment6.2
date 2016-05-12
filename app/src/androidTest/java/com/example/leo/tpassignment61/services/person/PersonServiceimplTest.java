package com.example.leo.tpassignment61.services.person;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.Person;
import com.example.leo.tpassignment61.repository.person.PersonRepository;
import com.example.leo.tpassignment61.repository.person.impl.PersonRepositoryimpl;
import com.example.leo.tpassignment61.services.person.impl.PersonServiceimpl;

import junit.framework.Assert;

/**
 * Created by Leo on 5/11/2016.
 */
public class PersonServiceimplTest extends AndroidTestCase {
    Intent intent;
    PersonRepository repo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new PersonRepositoryimpl(App.getAppContext());
    }

    public void testcreateperson ()throws Exception
    {
        PersonService personService = PersonServiceimpl.getInstance();

        Person person = new Person.Builder()
                .name("Liyolo")
                .surname("Moko")
                .email("www.google.com")
                .auvalue("LI001")
                .build();

        personService.addPerson(App.getAppContext(), person);
        Assert.assertEquals("Liyolo",person.getName());
    }

    public void testupdatePersonAddress()throws Exception
    {
        PersonService personService = PersonServiceimpl.getInstance();
        Person updateaddress = new Person.Builder()
                .name("Leo")
                .surname("Moko")
                .email("www.google.com")
                .auvalue("LI001")
                .build();
        personService.updatePerson(App.getAppContext(),updateaddress);
        Assert.assertEquals("Leo", updateaddress.getName());
    }
}
