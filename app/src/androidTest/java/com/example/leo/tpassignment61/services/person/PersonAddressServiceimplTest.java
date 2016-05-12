package com.example.leo.tpassignment61.services.person;;
import android.content.Intent;
import android.test.AndroidTestCase;
import java.util.*;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.PersonAddress;
import com.example.leo.tpassignment61.repository.person.PersonAddressRepository;
import com.example.leo.tpassignment61.repository.person.impl.PersonAddressRepositoryimpl;
import com.example.leo.tpassignment61.services.person.impl.PersonAddressServicesImpl;

import junit.framework.Assert;

/**
 * Created by Leo on 5/8/2016.
 */
public class PersonAddressServiceimplTest extends AndroidTestCase {
    Intent intent;
    PersonAddressRepository repo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new PersonAddressRepositoryimpl(App.getAppContext());
    }

    public void testPersonAddress() throws Exception {
        PersonAddressService personAddressService = PersonAddressServicesImpl.getInstance();
        PersonAddress address = new PersonAddress.Builder()
                .city("Cape Town")
                .country("South africa")
                .street("Satellite Drive")
                .sub("Kwezi Park")
                .build();

        personAddressService.addPersonAddress(App.getAppContext(), address);

        PersonAddress address1 = repo.read(1L);
        Assert.assertNotNull(address1);
    }
    public void testupdatePersonAddress() throws Exception
    {
        intent = new Intent(App.getAppContext(),PersonAddressServicesImpl.class);
        PersonAddressService personAddressService = new PersonAddressServicesImpl();

        PersonAddress updateaddress = new PersonAddress.Builder()
                .city("Cape Town")
                .country("South africa")
                .street("Satellite Drive")
                .sub("Khayelitsha")
                .build();
        personAddressService.updatePersonAddress(App.getAppContext(),updateaddress);
        App.getAppContext().startService(intent);
        Assert.assertEquals("Khayelitsha", updateaddress.getSub());
    }

    public void testNotNullOfDatabase() throws Exception {
        Set<PersonAddress> persons = repo.readAll();
        Assert.assertNotNull(persons);

    }
/*
    public void testSizeOfDatabase() throws Exception {
        Set<PersonAddress> persons = repo.readAll();
        Assert.assertEquals(persons.size(),10);

    }*/
}
