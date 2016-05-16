package com.example.leo.tpassignment61.services.user;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.PostAnEvent;
import com.example.leo.tpassignment61.factories.user.PostAnEventFactory;
import com.example.leo.tpassignment61.repository.user.PostAnEventRepository;
import com.example.leo.tpassignment61.repository.user.impl.PostAnEventRepositoryImp;
import com.example.leo.tpassignment61.services.user.impl.PostAnEventServiceimpl;

import junit.framework.Assert;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Leo on 5/8/2016.
 */
public class PostAnEventServiceimplTest extends AndroidTestCase
{
    Intent intent;
    PostAnEventRepository repo;
    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        intent = new Intent(App.getAppContext(),PostAnEventServiceimpl.class);
    }
    Date myDate = new Date(2016,05,8);
    public void testPostAnEvent()throws Exception
    {
        repo = new PostAnEventRepositoryImp(App.getAppContext());
        PostAnEventService postAnEventService = PostAnEventServiceimpl.getInstance();

        PostAnEvent postAnEvent = new PostAnEvent.Builder()
                .post("WE having fun")
                .tagline("#wepartylikekings")
                .date(myDate)
                .build();

        postAnEventService.postEvent(App.getAppContext(), postAnEvent);


    }

    public void testSizeOfDatabase() throws Exception {

        Set<PostAnEvent> postAnEvents = repo.readAll();
        Assert.assertEquals(postAnEvents.size(), 10);

    }
}
