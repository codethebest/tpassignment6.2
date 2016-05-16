package com.example.leo.tpassignment61.services.event;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.Event;
import com.example.leo.tpassignment61.repository.event.EventRepository;
import com.example.leo.tpassignment61.repository.event.impl.EventRepositoryimpl;
import com.example.leo.tpassignment61.services.event.impl.EventServiceimpl;

import junit.framework.Assert;
import java.util.Set;
/**
 * Created by Leo on 5/8/2016.
 */
public class EventServiceimplTest extends AndroidTestCase {
    Intent intent;
    EventRepository repo;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        repo = new EventRepositoryimpl(App.getAppContext());
    }

    public void testCreateEvent ()throws Exception
    {
        EventService eventService = EventServiceimpl.getInstance();
        Event event = new Event.Builder()
                .tagline("3lol")
                .name("Party Time")
                .host("Club 28")
                .description("Were we all have a blast on the park")
                .build();

        eventService.addEvent(App.getAppContext(),event);
        Assert.assertNotNull(event);
/*
        Set<Event> eventSet = repo.readAll();
        Assert.assertEquals(eventSet.size(), 20);*/
    }

    public void testDatabaseSize () throws Exception
    {
        Set<Event> eventSet = repo.readAll();
        Assert.assertEquals(eventSet.size(),2);
    }
}