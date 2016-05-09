package com.example.leo.tpassignment61.factories.event;

import com.example.leo.tpassignment61.domain.event.EventContact;

/**
 * Created by Leo on 4/18/2016.
 */
public class EventContactFactory {
    public static EventContact getEventContact (String phone ,String email, String website)
    {
        return new EventContact.Builder()
                .email(email)
                .phone(phone)
                .website(website)
                .build();
    }
}
