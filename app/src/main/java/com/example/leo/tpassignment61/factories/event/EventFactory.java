package com.example.leo.tpassignment61.factories.event;

import com.example.leo.tpassignment61.domain.event.Event;

/**
 * Created by Leo on 4/18/2016.
 */
public class EventFactory {
    public static Event getEvent (String tagline ,String host,String name )
    {
        return new Event.Builder()
                .host(host)
                .name(name)
                .tagline(tagline)
                .build();
    }
}
