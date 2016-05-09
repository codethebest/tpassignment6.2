package com.example.leo.tpassignment61.services.person;

import android.content.Context;

import com.example.leo.tpassignment61.domain.person.Person;

/**
 * Created by Leo on 5/8/2016.
 */
public interface PersonService {
    void addPerson(Context context,Person person);
    void updatePerson(Context context,Person person);
}
