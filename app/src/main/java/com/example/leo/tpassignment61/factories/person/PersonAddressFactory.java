package com.example.leo.tpassignment61.factories.person;

import com.example.leo.tpassignment61.domain.person.PersonAddress;

/**
 * Created by Leo on 4/18/2016.
 */
public class PersonAddressFactory {
    public static PersonAddress getAddress(String street , String sub,String country ,String city)
    {
        return new PersonAddress.Builder()
                .street(street)
                .sub(sub)
                .country(country)
                .city(city)
                .build();
    }
}