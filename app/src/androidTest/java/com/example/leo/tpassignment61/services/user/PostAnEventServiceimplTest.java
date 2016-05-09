package com.example.leo.tpassignment61.services.user;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.PostAnEvent;
import com.example.leo.tpassignment61.factories.user.PostAnEventFactory;
import com.example.leo.tpassignment61.services.user.impl.PostAnEventServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class PostAnEventServiceimplTest extends AndroidTestCase{
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        PostAnEvent p = PostAnEventFactory.getPostAnEvent("Big Night Mint","#funtimes");
        Intent intent = new Intent(App.getAppContext(),PostAnEventServiceimpl.class);
        intent.putExtra(PostAnEventServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
