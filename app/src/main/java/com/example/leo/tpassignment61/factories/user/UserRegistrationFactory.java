package com.example.leo.tpassignment61.factories.user;

import com.example.leo.tpassignment61.domain.user.UserRegistration;

/**
 * Created by Leo on 4/18/2016.
 */
public class UserRegistrationFactory {
    public static UserRegistration getUserRegistration(String useremail,String password , String name,String gender)
    {
        return new UserRegistration.Builder()
                .useremail(useremail)
                .newPassword(password)
                //.gender(gender)
                .name(name)
                .build();
    }
}
