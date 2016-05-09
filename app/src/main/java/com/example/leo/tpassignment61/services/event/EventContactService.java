package com.example.leo.tpassignment61.services.event;

import android.content.Context;

import com.example.leo.tpassignment61.domain.event.EventContact;

/**
 * Created by Leo on 5/8/2016.
 */
public interface EventContactService {
    void addEventContact(Context context,EventContact eventContact);
    void updateEventContact(Context context,EventContact eventContact);
}
