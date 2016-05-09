package com.example.leo.tpassignment61.factories.user;

import com.example.leo.tpassignment61.domain.user.PostAnEvent;

/**
 * Created by Leo on 4/24/2016.
 */
public class PostAnEventFactory {
    public static PostAnEvent getPostAnEvent (String postText,String hashTag)
    {
        return new PostAnEvent.Builder()
                .post(postText)
                .tagline(hashTag)
                .build();
}
}
