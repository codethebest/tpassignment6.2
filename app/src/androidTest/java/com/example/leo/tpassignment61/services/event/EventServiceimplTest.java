package com.example.leo.tpassignment61.services.event;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.Event;
import com.example.leo.tpassignment61.factories.event.EventFactory;
import com.example.leo.tpassignment61.services.event.impl.EventServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class EventServiceimplTest extends AndroidTestCase {
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        Event p = EventFactory.getEvent("#BigTime","Club808","Big Time")
        Intent intent = new Intent(App.getAppContext(),EventServiceimpl.class);
        intent.putExtra(EventServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
