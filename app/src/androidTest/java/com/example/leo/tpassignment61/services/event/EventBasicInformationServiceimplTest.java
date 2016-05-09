package com.example.leo.tpassignment61.services.event;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.event.EventBasicInformation;
import com.example.leo.tpassignment61.factories.event.EventBasicInformationFactory;
import com.example.leo.tpassignment61.services.event.impl.EventBasicInformationServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class EventBasicInformationServiceimplTest extends AndroidTestCase{
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        EventBasicInformation p = EventBasicInformationFactory.getEventBasicInformation("PoolParty")
        Intent intent = new Intent(App.getAppContext(),EventBasicInformationServiceimpl.class);
        intent.putExtra(EventBasicInformationServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
