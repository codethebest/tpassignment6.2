package com.example.leo.tpassignment61.services.event.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.Event;
import com.example.leo.tpassignment61.domain.event.EventContact;
import com.example.leo.tpassignment61.repository.event.EventRepository;
import com.example.leo.tpassignment61.repository.event.impl.EventRepositoryimpl;
import com.example.leo.tpassignment61.services.event.EventContactService;
import com.example.leo.tpassignment61.services.event.EventService;

import java.sql.SQLException;

/*** I used intent services because its a service that starts as needed,
 * handles each Intent in turn using a worker thread, and stops itself when it runs out of work.
 * Created by Leo on 5/8/2016.
 */
public class EventServiceimpl extends IntentService implements EventService {
    private final EventRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.event.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.event.impl.action.UPDATE";

    // TODO: Rename parameters
    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.event.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.event.impl.extra.UPDATE";

    private static EventServiceimpl service = null;

    public static EventServiceimpl getInstance()
    {
        if(service ==null)
            service = new EventServiceimpl();
        return service;
    }

    public EventServiceimpl() {
        super("EventServiceimpl");
        repo= new EventRepositoryimpl(App.getAppContext());
    }

    @Override
    public void addEvent(Context context,Event event)
    {
        Intent intent = new Intent (context,EventServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, event);
        context.startService(intent);
    }

    @Override
    public void updateEvent(Context context,Event event)
    {
        Intent intent =new Intent(context,EventServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, event);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent){
        try {
            if (intent != null) {
                final String action = intent.getAction();
                if (ACTION_ADD.equals(action)) {
                    final Event event = (Event) intent.getSerializableExtra(EXTRA_ADD);
                    Event createEvent = new Event.Builder()
                            .name(event.getName())
                            .tagline(event.getTagline())
                            .description(event.getDescription())
                            .host(event.getHost())
                            .build();
                    repo.save(createEvent);

                } else if (ACTION_UPDATE.equals(action)) {
                    final Event event = (Event) intent.getSerializableExtra(EXTRA_ADD);
                    Event updateEvent = new Event.Builder()
                            .name(event.getName())
                            .tagline(event.getTagline())
                            .description(event.getDescription())
                            .host(event.getHost())
                            .build();

                    repo.update(updateEvent);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
