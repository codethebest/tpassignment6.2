/*package com.example.leo.tpassignment61.services.event.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventBasicInformation;
import com.example.leo.tpassignment61.repository.event.EventBasicInformationRepository;
import com.example.leo.tpassignment61.repository.event.impl.EventBasicInformationRepositoryimpl;
import com.example.leo.tpassignment61.services.event.EventBasicInformationService;

import java.sql.SQLException;
import java.util.Set;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 *
public class EventBasicInformationServiceimpl extends IntentService implements EventBasicInformationService {
   /*
    private final EventBasicInformationRepository repo;
    private static final String ACTION_ADD = "com.example.leo.tpassignment61.services.event.impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.event.impl.action.UPDATE";


    private static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.event.impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.event.impl.extra.UPDATE";

    private static EventBasicInformationServiceimpl service = null;

    public static EventBasicInformationServiceimpl getInstance() {
        if (service == null)
            service = new EventBasicInformationServiceimpl();
        return service;
    }

    public EventBasicInformationServiceimpl() {
        super("EventBasicInformationServiceimpl");
        repo = new EventBasicInformationRepositoryimpl(App.getAppContext());
    }

    @Override
    public void addEventBasicInformation(Context context, EventBasicInformation eventContact) {
        Intent intent = new Intent(context, EventBasicInformationServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, eventContact);
        context.startService(intent);
    }

    @Override
    public void updateEventBasicInformation(Context context, EventBasicInformation address) {
        Intent intent = new Intent(context, EventBasicInformationServiceimpl.class);
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
                    EventBasicInformation eventContact = (EventBasicInformation) intent.getSerializableExtra(EXTRA_ADD);
                    EventBasicInformation createEventContact = new EventBasicInformation.Builder()
                            .end(eventContact.getEnd())
                            .eventtye(eventContact.getEventtype())
                            .start(eventContact.getStart())
                            .build();
                    repo.save(createEventContact);
                } else if (ACTION_UPDATE.equals(action)) {
                    EventBasicInformation eventContact = (EventBasicInformation) intent.getSerializableExtra(EXTRA_ADD);
                    EventBasicInformation updatePersonContact = new EventBasicInformation.Builder()
                            .end(eventContact.getEnd())
                            .eventtye(eventContact.getEventtype())
                            .start(eventContact.getStart())
                            .build();
                    repo.update(updatePersonContact);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
*/