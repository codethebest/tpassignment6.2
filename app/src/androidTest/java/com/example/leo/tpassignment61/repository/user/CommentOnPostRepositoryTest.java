package com.example.leo.tpassignment61.repository.user;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.user.CommentOnPost;
import com.example.leo.tpassignment61.repository.user.impl.CommentOnPostRepositoryImp;

import org.junit.Assert;

import java.util.Date;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by Leo on 4/25/2016.
 */
public class CommentOnPostRepositoryTest extends AndroidTestCase{
    private static final String TAG = "CommentONPost TEST";
    private CommentOnPostRepository repo;
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        Date mydate = new Date(1996,02,14);
        repo = new CommentOnPostRepositoryImp(this.getContext());

        CommentOnPost createEntity = new CommentOnPost.Builder()
                .post("We having fun at my house")
                .date(mydate)
                .build();
        CommentOnPost insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        Set postAnEvent = repo.readAll();
        Assert.assertFalse(TAG + " READ ALL", postAnEvent.size() == 0);



        CommentOnPost entity = repo.read(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        CommentOnPost updataEntity = new CommentOnPost.Builder()
                .copy(entity)
                .date(mydate)
                .build();
        repo.update(updataEntity);
        CommentOnPost newEntity = repo.read(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "We having fun at my house", newEntity.getPost());

        repo.delete(updataEntity);
        CommentOnPost delelteEntity = repo.read(id);
        Assert.assertNull(TAG+ " DELETE",delelteEntity);

    }
}


