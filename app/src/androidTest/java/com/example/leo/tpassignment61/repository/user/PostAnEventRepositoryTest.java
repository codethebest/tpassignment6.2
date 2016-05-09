package com.example.leo.tpassignment61.repository.user;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.user.PostAnEvent;
import com.example.leo.tpassignment61.repository.user.impl.PostAnEventRepositoryImp;

import junit.framework.Assert;

import java.util.Date;
import java.util.Set;
/**
 * Created by Leo on 4/25/2016.
 */
public class PostAnEventRepositoryTest extends AndroidTestCase{
    private static final String TAG = "POSTANEVENT TEST";
    private PostAnEventRepository objpostAnEventRepo;
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        objpostAnEventRepo = new PostAnEventRepositoryImp(this.getContext());
        Date mydate = new Date(2016,02,8);
        PostAnEvent createEntity = new PostAnEvent.Builder()
                .post("We having fun at my house")
                .tagline("#funtime")
                .date(mydate)
                .build();
        PostAnEvent insertedEntity = objpostAnEventRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        Set postAnEvent = objpostAnEventRepo.readAll();
        Assert.assertFalse(TAG + " READ ALL", postAnEvent.size() == 0);



        PostAnEvent entity = objpostAnEventRepo.read(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        PostAnEvent updataEntity = new PostAnEvent.Builder()
                .copy(entity)
                .date(mydate)
                .tagline("#FunRide")
                .build();
        objpostAnEventRepo.update(updataEntity);
        PostAnEvent newEntity = objpostAnEventRepo.read(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","#FunRide",newEntity.getTagline());

        objpostAnEventRepo.delete(updataEntity);
        PostAnEvent delelteEntity = objpostAnEventRepo.read(id);
        Assert.assertNull(TAG+ " DELETE",delelteEntity);

    }
}
