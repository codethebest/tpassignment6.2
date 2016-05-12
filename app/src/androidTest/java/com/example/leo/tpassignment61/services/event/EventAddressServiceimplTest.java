package com.example.leo.tpassignment61.services.event;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventAddress;
import com.example.leo.tpassignment61.repository.event.EventAddressRepository;
import com.example.leo.tpassignment61.repository.event.impl.EventAddressRepositoryimpl;
import com.example.leo.tpassignment61.services.event.impl.EventAddressServiceimpl;
import com.example.leo.tpassignment61.services.event.impl.EventServiceimpl;

import junit.framework.Assert;
import java.util.*;
/**
 * Created by Leo on 5/8/2016.
 */
public class EventAddressServiceimplTest extends AndroidTestCase{
    Intent intent;
    EventAddressRepository repo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repo = new EventAddressRepositoryimpl(App.getAppContext());
    }

    public void testEventAddress() throws Exception
    {
        EventAddressService personAddressService = EventAddressServiceimpl.getInstance();

        EventAddress address = new EventAddress.Builder()
                .city("Cape Town")
                .country("South africa")
                .street("Satellite Drive")
                .sub("Kwezi Park")
                .build();

        personAddressService.addPEventAddress(App.getAppContext(), address);

       /*EventAddress address1 = repo.read(1L);
        Assert.assertNotNull(address1);*/
    }
    public void testSizeOfDatabase() throws Exception {
        Set<EventAddress> eventAddresses = repo.readAll();
        Assert.assertEquals(eventAddresses.size(),10);

    }
}
