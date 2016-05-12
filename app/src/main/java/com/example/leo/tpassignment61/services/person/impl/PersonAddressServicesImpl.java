package com.example.leo.tpassignment61.services.person.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.PersonAddress;
import com.example.leo.tpassignment61.repository.person.PersonAddressRepository;
import com.example.leo.tpassignment61.repository.person.impl.PersonAddressRepositoryimpl;
import com.example.leo.tpassignment61.services.person.PersonAddressService;

import java.io.IOException;
import java.sql.SQLException;

public class PersonAddressServicesImpl extends IntentService implements PersonAddressService{

    private final PersonAddressRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.person.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.person.impl.action.UPDATE";

    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.person.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.person.impl.extra.UPDATE";

    private static PersonAddressServicesImpl service = null;

    public static PersonAddressServicesImpl getInstance()
    {
        if(service ==null)
            service = new PersonAddressServicesImpl();
        return service;
    }

    public PersonAddressServicesImpl() {
        super("PersonAddressServicesImpl");
        repo= new PersonAddressRepositoryimpl(App.getAppContext());
    }

    @Override
    public void addPersonAddress(Context context,PersonAddress address)
    {
        Intent intent = new Intent (context,PersonAddressServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, address);
        context.startService(intent);
    }

    @Override
    public void updatePersonAddress(Context context,PersonAddress address)
    {
        Intent intent =new Intent(context,PersonAddressServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, address);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            final String action = intent.getAction();
            if (intent != null)
            {
                if(ACTION_ADD.equals(action)) {
                    PersonAddress personAddressResources = (PersonAddress) intent.getSerializableExtra(EXTRA_ADD);
                    PersonAddress createpersonAddress = new PersonAddress.Builder()
                            .city(personAddressResources.getCity())
                            .country(personAddressResources.getCountry())
                            .street(personAddressResources.getStreet())
                            .sub(personAddressResources.getSub())
                            .build();
                    repo.save(createpersonAddress);
                }
                else if (ACTION_UPDATE.equals(action))
                {
                    PersonAddress personAddressResources = (PersonAddress) intent.getSerializableExtra(EXTRA_UPDATE);
                    PersonAddress updatePersonAddress = new PersonAddress.Builder()
                            .city(personAddressResources.getCity())
                            .country(personAddressResources.getCountry())
                            .street(personAddressResources.getStreet())
                            .sub(personAddressResources.getSub())
                            .build();
                    repo.save(updatePersonAddress);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
