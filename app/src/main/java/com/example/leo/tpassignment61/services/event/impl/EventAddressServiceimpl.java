package com.example.leo.tpassignment61.services.event.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventAddress;
import com.example.leo.tpassignment61.repository.event.EventAddressRepository;
import com.example.leo.tpassignment61.repository.event.impl.EventAddressRepositoryimpl;
import com.example.leo.tpassignment61.services.event.EventAddressService;

import java.sql.SQLException;

/*** I used intent services because its a service that starts as needed,
 * handles each Intent in turn using a worker thread, and stops itself when it runs out of work.
 * Created by Leo on 5/8/2016.
 */
public class EventAddressServiceimpl extends IntentService implements EventAddressService{

    private final EventAddressRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.event.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.event.impl.action.UPDATE";

    // TODO: Rename parameters
    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.event.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.event.impl.extra.UPDATE";

    private static EventAddressServiceimpl service = null;

    public static EventAddressServiceimpl getInstance()
    {
        if(service ==null)
            service = new EventAddressServiceimpl();
        return service;
    }

    public EventAddressServiceimpl() {
        super("EventAddressServiceimpl");
        repo= new EventAddressRepositoryimpl(App.getAppContext());
    }

    @Override
    public void addPEventAddress(Context context,EventAddress address)
    {
        Intent intent = new Intent (context,EventAddressServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, address);
        context.startService(intent);
    }

    @Override
    public void updateEventAddress(Context context,EventAddress address)
    {
        Intent intent =new Intent(context,EventAddressServiceimpl.class);
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
                    final EventAddress eventAddressResources = (EventAddress) intent.getSerializableExtra(EXTRA_ADD);
                    EventAddress updateeventAddress = new EventAddress.Builder()
                            .city(eventAddressResources.getCity())
                            .country(eventAddressResources.getCountry())
                            .street(eventAddressResources.getStreet())
                            .sub(eventAddressResources.getSub())
                            .build();
                    repo.save(updateeventAddress);

                } else if (ACTION_UPDATE.equals(action)) {
                    final EventAddress eventAddressResources = (EventAddress) intent.getSerializableExtra(EXTRA_UPDATE);
                    EventAddress updateeventAddress = new EventAddress.Builder()
                            .city(eventAddressResources.getCity())
                            .country(eventAddressResources.getCountry())
                            .street(eventAddressResources.getStreet())
                            .sub(eventAddressResources.getSub())
                            .build();
                    repo.save(updateeventAddress);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

