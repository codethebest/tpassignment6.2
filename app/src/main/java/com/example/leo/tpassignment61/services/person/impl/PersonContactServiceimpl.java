package com.example.leo.tpassignment61.services.person.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.PersonContact;
import com.example.leo.tpassignment61.repository.person.PersonContactRepository;
import com.example.leo.tpassignment61.repository.person.impl.PersonContactRepositoryimpl;
import com.example.leo.tpassignment61.services.person.PersonContactService;

import java.sql.SQLException;

/*** I used intent services because its a service that starts as needed,
 * handles each Intent in turn using a worker thread, and stops itself when it runs out of work.
 * Created by Leo on 5/8/2016.
 */
public class PersonContactServiceimpl extends IntentService implements PersonContactService {
    private final PersonContactRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.person.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.person.impl.action.UPDATE";

    // TODO: Rename parameters
    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.person.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.person.impl.extra.UPDATE";

    private static PersonContactServiceimpl service = null;

    public static PersonContactServiceimpl getInstance()
    {
        if(service ==null)
            service = new PersonContactServiceimpl();
        return service;
    }

    public PersonContactServiceimpl() {
        super("PersonContactServiceimpl");
        repo= new PersonContactRepositoryimpl(App.getAppContext());
    }

    @Override
    public void addPersonContact(Context context,PersonContact address)
    {
        Intent intent = new Intent (context,PersonAddressServicesImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, address);
        context.startService(intent);
    }

    @Override
    public void updatePersonContact(Context context,PersonContact address)
    {
        Intent intent =new Intent(context,PersonContactServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, address);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            if (intent != null) {
                final String action = intent.getAction();
                if (ACTION_ADD.equals(action)) {
                    PersonContact personContact = (PersonContact) intent.getSerializableExtra(EXTRA_ADD);
                    PersonContact createPersonContact = new PersonContact.Builder()
                            .email(personContact.getEmail())
                            .mobile(personContact.getMobile())
                            .screenName(personContact.getScreenName())
                            .website(personContact.getWebsite())
                            .build();
                    repo.save(createPersonContact);
                } else if (ACTION_UPDATE.equals(action)) {
                    PersonContact personContact = (PersonContact) intent.getSerializableExtra(EXTRA_UPDATE);

                    PersonContact updatePersonContact = new PersonContact.Builder()
                            .email(personContact.getEmail())
                            .mobile(personContact.getMobile())
                            .screenName(personContact.getScreenName())
                            .website(personContact.getWebsite())
                            .build();
                    repo.update(updatePersonContact);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
