package com.example.leo.tpassignment61.services.person;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.PersonContact;
import com.example.leo.tpassignment61.factories.person.PersonContactFactory;
import com.example.leo.tpassignment61.services.person.impl.PersonContactServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class PersonContactimplTest extends AndroidTestCase {
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
