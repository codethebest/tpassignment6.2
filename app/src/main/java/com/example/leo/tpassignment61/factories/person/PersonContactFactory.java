package com.example.leo.tpassignment61.factories.person;

import com.example.leo.tpassignment61.domain.person.PersonContact;

/**
 * Created by Leo on 4/18/2016.
 */
public class PersonContactFactory {

    public static PersonContact getPersonContact(String screeName, long mobile,String email, String website)
    {
        return new PersonContact.Builder()
                .email(email)
                .screenName(screeName)
                .mobile(mobile)
                .website(website)
                .build();
    }
}