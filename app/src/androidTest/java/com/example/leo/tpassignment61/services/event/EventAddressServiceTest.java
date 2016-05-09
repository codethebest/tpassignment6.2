package com.example.leo.tpassignment61.services.event;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventAddress;
import com.example.leo.tpassignment61.factories.event.EventAddressFactory;
import com.example.leo.tpassignment61.repository.event.EventAddressRepository;
import com.example.leo.tpassignment61.services.event.impl.EventAddressServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class EventAddressServiceTest extends AndroidTestCase{
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        EventAddress p = EventAddressFactory.getEventAddress("16 satelite","kwezi Part","south afric","cape twon");
        Intent intent = new Intent(App.getAppContext(),EventAddressServiceimpl.class);
        intent.putExtra(EventAddressServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
