package com.example.leo.tpassignment61.services.user;

import android.content.Context;

import com.example.leo.tpassignment61.domain.user.CommentOnPost;

/**
 * Created by Leo on 5/8/2016.
 */
public interface CommentOnPostService {
    void postAnComment(Context context,CommentOnPost commentOnPost);
    void editComment(Context context,CommentOnPost commentOnPost);
}
