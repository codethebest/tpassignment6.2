package com.example.leo.tpassignment61.services.person;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.Person;
import com.example.leo.tpassignment61.domain.person.PersonAddress;
import com.example.leo.tpassignment61.factories.person.PersonAddressFactory;
import com.example.leo.tpassignment61.factories.person.PersonFactory;
import com.example.leo.tpassignment61.services.person.impl.PersonAddressServicesImpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class PersonAddressServiceimplTest extends AndroidTestCase{
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        PersonAddress p = PersonAddressFactory.getAddress("satellite drive","Kwezi Prk", "South africa","cape");
        Intent intent = new Intent(App.getAppContext(),PersonAddressServicesImpl.class);
        intent.putExtra(PersonAddressServicesImpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }

/*    private PersonAddressServicesImpl addressServices;
    private boolean isBound;

    @Override
    public void setUp()throws Exception
    {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(),PersonAddressService.class);
        App.getAppContext().bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }*/
}
