package com.example.leo.tpassignment61.services.person;

import android.content.Context;

import com.example.leo.tpassignment61.domain.person.PersonContact;

/**
 * Created by Leo on 5/8/2016.
 */
public interface PersonContactService {
    void addPersonContact(Context context,PersonContact personContactService);
    void updatePersonContact(Context context,PersonContact personContactService);
}
