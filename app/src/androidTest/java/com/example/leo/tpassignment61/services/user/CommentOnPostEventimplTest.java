package com.example.leo.tpassignment61.services.user;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.CommentOnPost;
import com.example.leo.tpassignment61.factories.user.CommentOnPostFactory;
import com.example.leo.tpassignment61.services.user.impl.CommentOnPostServiceimpl;

/**
 * Created by Leo on 5/8/2016.
 */
public class CommentOnPostEventimplTest extends AndroidTestCase{
    Intent intent;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        CommentOnPost p = CommentOnPostFactory.getCommentPost("Am going ther");
        Intent intent = new Intent(App.getAppContext(),CommentOnPostServiceimpl.class);
        intent.putExtra(CommentOnPostServiceimpl.ACTION_ADD,p);
        App.getAppContext().startService(intent);
    }
}
