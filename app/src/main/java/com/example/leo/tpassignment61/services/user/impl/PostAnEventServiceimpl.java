package com.example.leo.tpassignment61.services.user.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.PostAnEvent;
import com.example.leo.tpassignment61.repository.user.PostAnEventRepository;
import com.example.leo.tpassignment61.repository.user.impl.PostAnEventRepositoryImp;
import com.example.leo.tpassignment61.services.user.PostAnEventService;

import java.sql.SQLException;

/**
 * * I used intent services because its a service that starts as needed,
 * handles each Intent in turn using a worker thread, and stops itself when it runs out of work.
 * Created by Leo on 5/8/2016.
 */
public class PostAnEventServiceimpl extends IntentService implements PostAnEventService {
    private final PostAnEventRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.user.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.user.impl.action.UPDATE";

    // TODO: Rename parameters
    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.user.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.user.impl.extra.UPDATE";

    private static PostAnEventServiceimpl service = null;

    public static PostAnEventServiceimpl getInstance()
    {
        if(service ==null)
            service = new PostAnEventServiceimpl();
        return service;
    }

    public PostAnEventServiceimpl() {
        super("PostAnEventServiceimpl");
        repo= new PostAnEventRepositoryImp(App.getAppContext());
    }

    @Override
    public void postEvent(Context context,PostAnEvent address)
    {
       Log.i("At Context", "Looking at editPost()");
        Intent intent = new Intent (context,PostAnEventServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, address);
        context.startService(intent);
    }

    @Override
    public void editPost(Context context,PostAnEvent address)
    {

        Intent intent =new Intent(context,PostAnEventServiceimpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, address);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("Service strated","Im here");
        try{
            if (intent != null) {
                String action = intent.getAction();
                if (ACTION_ADD.equals(action)) {
                    final PostAnEvent postAnEventResourse = (PostAnEvent)intent.getSerializableExtra(EXTRA_ADD);
                    PostAnEvent postAnEvent = new PostAnEvent.Builder()
                            .tagline(postAnEventResourse.getTagline())
                            .post(postAnEventResourse.getPost())
                            .date(postAnEventResourse.getDate())
                            .build();
                    repo.save(postAnEvent);
                    Log.i("At onHandle", "started..................");
                } else if (ACTION_UPDATE.equals(action)) {
                    final PostAnEvent postAnEventResourse = (PostAnEvent)intent.getSerializableExtra(EXTRA_UPDATE);
                    PostAnEvent updatetAnEvent = new PostAnEvent.Builder()
                            .tagline(postAnEventResourse.getTagline())
                            .post(postAnEventResourse.getPost())
                            .date(postAnEventResourse.getDate())
                            .build();
                    repo.update(updatetAnEvent);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

