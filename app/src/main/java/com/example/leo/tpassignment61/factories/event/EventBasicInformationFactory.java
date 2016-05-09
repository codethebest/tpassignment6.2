package com.example.leo.tpassignment61.factories.event;

import com.example.leo.tpassignment61.domain.event.EventBasicInformation;

import java.util.Date;

/**
 * Created by Leo on 4/18/2016.
 */
public class EventBasicInformationFactory {
    public static EventBasicInformation getEventBasicInformation (String eventtype)
    {
        return new EventBasicInformation.Builder()
                .end(new Date())
                .start(new Date())
                .eventtye(eventtype)
                .build();
    }
}