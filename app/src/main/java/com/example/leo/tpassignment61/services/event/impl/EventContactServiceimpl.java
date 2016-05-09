package com.example.leo.tpassignment61.services.event.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventContact;
import com.example.leo.tpassignment61.repository.event.EventContactRepository;
import com.example.leo.tpassignment61.repository.event.impl.EventContactRepositoryimpl;
import com.example.leo.tpassignment61.services.event.EventContactService;

import java.sql.SQLException;

/**
 * Created by Leo on 5/8/2016.
 */
public class EventContactServiceimpl extends IntentService implements EventContactService {
    private final EventContactRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.event.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.event.impl.action.UPDATE";

    // TODO: Rename parameters
    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.event.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.event.impl.extra.UPDATE";

    private static EventContactServiceimpl service = null;

    public static EventContactServiceimpl getInstance()
    {
        if(service ==null)
            service = new EventContactServiceimpl();
        return service;
    }

    public EventContactServiceimpl() {
        super("EventContactServiceimpl");
        repo= new EventContactRepositoryimpl(App.getAppContext());
    }

    @Override
    public void addEventContact(Context context,EventContact eventContact)
    {
        Intent intent = new Intent (context,EventContactServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, eventContact);
        context.startService(intent);
    }

    @Override
    public void updateEventContact(Context context,EventContact address)
    {
        Intent intent =new Intent(context,EventContactServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, address);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final EventContact personContact = (EventContact)intent.getSerializableExtra(EXTRA_ADD);

                postAddress(personContact);
            } else if (ACTION_UPDATE.equals(action)) {
                final EventContact personContact = (EventContact)intent.getSerializableExtra(EXTRA_UPDATE);;
                updateaddress(personContact);
            }
        }
    }

    public void postAddress(EventContact personAddress)
    {
        try {
            repo.save(personAddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateaddress(EventContact personAddress) {
        try {
            repo.save(personAddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
