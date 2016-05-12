package com.example.leo.tpassignment61.services.user;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.UserRegistration;
import com.example.leo.tpassignment61.repository.user.UserRegistrationRepository;
import com.example.leo.tpassignment61.repository.user.impl.UserRegistrationRepositoryImp;
import com.example.leo.tpassignment61.services.user.impl.UserRegistrationServiceimpl;

import junit.framework.Assert;

import java.util.*;
/**
 * Created by Leo on 5/8/2016.
 **/
public class UserRegistrationServiceimplTest extends AndroidTestCase{
    Intent intent;
    UserRegistrationRepository repo;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        repo = new UserRegistrationRepositoryImp(App.getAppContext());
    }

    public void testRegistration ()throws Exception
    {
        UserRegistrationService userRegistrationService = UserRegistrationServiceimpl.getInstance();

        UserRegistration userRegistration = new UserRegistration.Builder()
                .name("liyolo")
                .useremail("leo1996")
                .gender("male")
                .newPassword("12sdf")
                .build();

        userRegistrationService.addUser(App.getAppContext(),userRegistration);

    }

    public void testSizeDatabase ()throws Exception
    {
        Set<UserRegistration> userRegistrations = repo.readAll();
        Assert.assertEquals(userRegistrations.size(),0);
    }
}

