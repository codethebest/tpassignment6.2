package com.example.leo.tpassignment61.services.event;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventContact;
import com.example.leo.tpassignment61.factories.event.EventContactFactory;
import com.example.leo.tpassignment61.services.event.impl.EventContactServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class EventContactServiceimplTest extends AndroidTestCase{
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        EventContact p = EventContactFactory.getEventContact("leo","leo.moo", "www.google");
        Intent intent = new Intent(App.getAppContext(),EventContactServiceimpl.class);
        intent.putExtra(EventContactServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
