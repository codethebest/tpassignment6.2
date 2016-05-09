package com.example.leo.tpassignment61.services.user;

import android.content.Intent;

import com.example.leo.tpassignment61.conf.databases.App;

/**
 * Created by Leo on 5/8/2016.
 */
public class UserRegistrationServiceimplTest {
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        PersonContact p = PersonContactFactory.getPersonContact("leo",023,"leo.moo","www.google");
        Intent intent = new Intent(App.getAppContext(),PersonContactServiceimpl.class);
        intent.putExtra(PersonContactServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
