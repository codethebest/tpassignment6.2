package com.example.leo.tpassignment61.services.user.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.UserRegistration;
import com.example.leo.tpassignment61.repository.user.UserRegistrationRepository;
import com.example.leo.tpassignment61.repository.user.impl.UserRegistrationRepositoryImp;
import com.example.leo.tpassignment61.services.user.UserRegistrationService;

import java.sql.SQLException;

/**
 * I used intent services because its a service that starts as needed,
 * handles each Intent in turn using a worker thread, and stops itself when it runs out of work.
 * Created by Leo on 5/8/2016.
 */
public class UserRegistrationServiceimpl extends IntentService implements UserRegistrationService{
    private final UserRegistrationRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.user.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.user.impl.action.UPDATE";

    // TODO: Rename parameters
    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.person.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.person.impl.extra.UPDATE";

    private static UserRegistrationServiceimpl service = null;

    public static UserRegistrationServiceimpl getInstance()
    {
        if(service ==null)
            service = new UserRegistrationServiceimpl();
        return service;
    }

    public UserRegistrationServiceimpl() {
        super("UserRegistrationServiceimpl");
        repo= new UserRegistrationRepositoryImp(App.getAppContext());
    }

    @Override
    public void addUser(Context context,UserRegistration address)
    {
        Intent intent = new Intent (context,UserRegistrationServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, address);
        context.startService(intent);
    }

    @Override
    public void updateUser(Context context,UserRegistration address)
    {
        Intent intent =new Intent(context,UserRegistrationServiceimpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, address);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
       try{
           if (intent != null) {
               final String action = intent.getAction();
               if (ACTION_ADD.equals(action)) {
                   final UserRegistration userRegistrationResourse = (UserRegistration)intent.getSerializableExtra(EXTRA_ADD);
                   UserRegistration userRegistration = new UserRegistration.Builder()
                           .name(userRegistrationResourse.getName())
                           .gender(userRegistrationResourse.getGender())
                           .useremail(userRegistrationResourse.getUseremail())
                           .newPassword(userRegistrationResourse.getNewPassword())
                           .build();
                   repo.save(userRegistration);

               } else if (ACTION_UPDATE.equals(action)) {
                   final UserRegistration userRegistrationResourse = (UserRegistration)intent.getSerializableExtra(EXTRA_UPDATE);
                   UserRegistration updateRegistration = new UserRegistration.Builder()
                           .name(userRegistrationResourse.getName())
                           .gender(userRegistrationResourse.getGender())
                           .useremail(userRegistrationResourse.getUseremail())
                           .newPassword(userRegistrationResourse.getNewPassword())
                           .build();
                   repo.update(updateRegistration);
               }
           }
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }

}
