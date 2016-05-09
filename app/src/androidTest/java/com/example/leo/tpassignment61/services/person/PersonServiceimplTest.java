package com.example.leo.tpassignment61.services.person;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.Person;
import com.example.leo.tpassignment61.factories.person.PersonFactory;
import com.example.leo.tpassignment61.services.person.impl.PersonServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class PersonServiceimplTest extends AndroidTestCase {
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        Person p = PersonFactory.getPerson("leo.moo8@gmail.com","252d");
        Intent intent = new Intent(App.getAppContext(),PersonServiceimpl.class);
        intent.putExtra(PersonServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
