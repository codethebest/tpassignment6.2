package com.example.leo.tpassignment61.services.event;

import android.content.Context;

import com.example.leo.tpassignment61.domain.event.Event;

/**
 * Created by Leo on 5/8/2016.
 */
public interface EventService{
    void addEvent(Context context,Event event);
    void updateEvent(Context context,Event Event);
}
