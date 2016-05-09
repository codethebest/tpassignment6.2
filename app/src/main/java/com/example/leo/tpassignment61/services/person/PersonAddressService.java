package com.example.leo.tpassignment61.services.person;

import android.content.Context;

import com.example.leo.tpassignment61.domain.person.PersonAddress;

/**
 * Created by Leo on 5/8/2016.
 */
public interface PersonAddressService {
    void addPersonAddress(Context context,PersonAddress address);
    void updatePersonAddress(Context context,PersonAddress address);
}
