package com.example.leo.tpassignment61.services.user.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.example.leo.tpassignment61.conf.databases.App;
import com.example.leo.tpassignment61.domain.user.CommentOnPost;
import com.example.leo.tpassignment61.repository.user.CommentOnPostRepository;
import com.example.leo.tpassignment61.repository.user.impl.CommentOnPostRepositoryImp;
import com.example.leo.tpassignment61.services.user.CommentOnPostService;

import java.io.IOException;
import java.sql.SQLException;

public class CommentOnPostServiceimpl extends IntentService implements CommentOnPostService{

    private final CommentOnPostRepository repo;
    private static final String ACTION_POST = "com.example.leo.tpassignment61.services.user.impl.action.POST";
    private static final String ACTION_EDIT = "com.example.leo.tpassignment61.services.user.impl.action.EDIT";

    // TODO: Rename parameters
    private static final String EXTRA_POST = "com.example.leo.tpassignment61.services.user.impl.extra.POST";
    private static final String EXTRA_EDIT = "com.example.leo.tpassignment61.services.user.impl.extra.EDIT";

    private static CommentOnPostServiceimpl service = null;
    public static CommentOnPostServiceimpl getInstance()
    {
        if(service == null)
            service = new CommentOnPostServiceimpl();
        return service;
    }
    public CommentOnPostServiceimpl() {
        super("CommentOnPostServiceimpl");
        repo = new CommentOnPostRepositoryImp(App.getAppContext());
    }

    public void postAnComment(Context context, CommentOnPost comment) {
        Intent intent = new Intent(context, CommentOnPostServiceimpl.class);
        intent.setAction(ACTION_POST);
        intent.putExtra(EXTRA_POST, comment);
        context.startService(intent);
    }

    public void editComment(Context context, CommentOnPost comment) {
        Intent intent = new Intent(context, CommentOnPostServiceimpl.class);
        intent.setAction(ACTION_POST);
        intent.putExtra(EXTRA_EDIT, comment);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            if (intent != null) {
                final String action = intent.getAction();
                if (ACTION_POST.equals(action)) {
                    final CommentOnPost commentOnPostResourse = (CommentOnPost) intent.getSerializableExtra(EXTRA_POST);
                    CommentOnPost commentOnPost = new CommentOnPost.Builder()
                            .post(commentOnPostResourse.getPost())
                            .date(commentOnPostResourse.getDate())
                            .build();
                    repo.save(commentOnPost);
                } else if (ACTION_EDIT.equals(action)) {
                    final CommentOnPost commentOnPostResourse = (CommentOnPost) intent.getSerializableExtra(EXTRA_POST);
                    CommentOnPost commentOnPost = new CommentOnPost.Builder()
                            .post(commentOnPostResourse.getPost())
                            .date(commentOnPostResourse.getDate())
                            .build();
                    repo.update(commentOnPost);
                }
            }
        }
        catch (Exception e){e.printStackTrace();}

    }
}

