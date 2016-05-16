package com.example.leo.tpassignment61.services.user;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.CommentOnPost;
import com.example.leo.tpassignment61.factories.user.CommentOnPostFactory;
import com.example.leo.tpassignment61.repository.user.CommentOnPostRepository;
import com.example.leo.tpassignment61.repository.user.impl.CommentOnPostRepositoryImp;
import com.example.leo.tpassignment61.services.user.impl.CommentOnPostServiceimpl;

import junit.framework.Assert;

import java.util.*;

/**
 * Created by Leo on 5/8/2016.
 */
public class CommentOnPostEventimplTest extends AndroidTestCase{
    Intent intent;
    CommentOnPostRepository repo;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        repo = new CommentOnPostRepositoryImp(App.getAppContext());
    }
    Date myDate = new Date(2016,05,8);

    public void testComment ()throws Exception {
        CommentOnPostService commentOnPostService = CommentOnPostServiceimpl.getInstance();

        CommentOnPost commentOnPost = new CommentOnPost.Builder()
                .post("Lol mate ")
                .date(myDate)
                .build();

        commentOnPostService.postAnComment(App.getAppContext(), commentOnPost);
        Assert.assertNotNull(commentOnPost);
/*
        Thread.sleep(1000);
        CommentOnPost post = repo.read(1L);
        Assert.assertNotNull(post);*/
    }


    public void testupdatePersonAddress() throws Exception
    {
        CommentOnPostService commentOnPostService = CommentOnPostServiceimpl.getInstance();

        CommentOnPost commentOnPost = new CommentOnPost.Builder()
                .post("Lol mate ")
                .date(myDate)
                .build();

        commentOnPostService.editComment(App.getAppContext(),commentOnPost);
//        App.getAppContext().startService(intent);
        Assert.assertEquals("Lol mate ", commentOnPost.getPost());
    }


    public void testSizeDatabase()throws Exception
    {
        Set<CommentOnPost> commentOnPosts = repo.readAll();
        Assert.assertEquals(commentOnPosts.size(),10);
    }
}
