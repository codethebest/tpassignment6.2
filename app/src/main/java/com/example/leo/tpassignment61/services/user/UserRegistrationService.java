package com.example.leo.tpassignment61.services.user;

import android.content.Context;

import com.example.leo.tpassignment61.domain.user.UserRegistration;

/**
 * Created by Leo on 5/8/2016.
 */
public interface UserRegistrationService {
    void addUser(Context context,UserRegistration userRegistration);
    void updateUser(Context context,UserRegistration userRegistration);
}
