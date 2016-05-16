package com.example.leo.tpassignment61.services.person.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.person.Person;
import com.example.leo.tpassignment61.repository.person.PersonRepository;
import com.example.leo.tpassignment61.repository.person.impl.PersonRepositoryimpl;
import com.example.leo.tpassignment61.services.person.PersonService;

import java.sql.SQLException;

/*** I used intent services because its a service that starts as needed,
 * handles each Intent in turn using a worker thread, and stops itself when it runs out of work.
 * Created by Leo on 5/8/2016.
 */
public class PersonServiceimpl extends IntentService implements PersonService{
    private final PersonRepository repo;

    public static final String ACTION_ADD = "com.example.leo.tpassignment61.services.person.impl.action.ADD";
    public static final String ACTION_UPDATE = "com.example.leo.tpassignment61.services.person.impl.action.UPDATE";

    // TODO: Rename parameters
    public static final String EXTRA_ADD = "com.example.leo.tpassignment61.services.person.impl.extra.ADD";
    public static final String EXTRA_UPDATE = "com.example.leo.tpassignment61.services.person.impl.extra.UPDATE";

    private static PersonServiceimpl service = null;

    public static PersonServiceimpl getInstance()
    {
        if(service ==null)
            service = new PersonServiceimpl();
        return service;
    }

    public PersonServiceimpl() {
        super("PersonServiceimpl");
        repo= new PersonRepositoryimpl(App.getAppContext());
    }

    @Override
    public void addPerson(Context context,Person address)
    {
        Intent intent = new Intent (context,PersonServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, address);
        context.startService(intent);
    }

    @Override
    public void updatePerson(Context context,Person address)
    {
        Intent intent =new Intent(context,PersonServiceimpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, address);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent){
        try {
            if (intent != null) {
                final String action = intent.getAction();
                if (ACTION_ADD.equals(action)) {
                    final Person person = (Person) intent.getSerializableExtra(EXTRA_ADD);
                    Person createPerson = new Person.Builder()
                            .name(person.getName())
                            .surname(person.getEmail())
                            .email(person.getEmail())
                            .auvalue(person.getAuvalue())
                            .build();
                    repo.save(createPerson);

                } else if (ACTION_UPDATE.equals(action)) {
                    final Person person = (Person) intent.getSerializableExtra(EXTRA_UPDATE);
                    Person updatePerson = new Person.Builder()
                            .name(person.getName())
                            .surname(person.getEmail())
                            .email(person.getEmail())
                            .auvalue(person.getAuvalue())
                            .build();
                    repo.update(updatePerson);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
