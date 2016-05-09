package com.example.leo.tpassignment61.services.user;

import android.content.Context;

import com.example.leo.tpassignment61.domain.user.PostAnEvent;

/**
 * Created by Leo on 5/8/2016.
 */
public interface PostAnEventService {
    void postEvent(Context context,PostAnEvent postAnEvent);
    void editPost(Context context,PostAnEvent postAnEvent);
}
