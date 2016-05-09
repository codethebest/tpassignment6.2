package com.example.leo.tpassignment61.repository.event;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.event.Event;
import com.example.leo.tpassignment61.repository.event.impl.EventRepositoryimpl;
import java.util.Set;
import org.junit.Assert;

/**
 * Created by Leo on 5/7/2016.
 */
public class EventRepositoryimplTest extends AndroidTestCase{
    private static final String TAG ="EVENT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception
    {
        EventRepository repo = new EventRepositoryimpl(this.getContext());
        Event createEntity = new Event.Builder()
                .name("ZIYAWA")
                .host("RandsClub")
                .tagline("#ZIYAWA")
                .build();
        Event insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);


        Set<Event> personSet = repo.readAll();
        Assert.assertTrue(TAG + " READ ALL", personSet.size() > 0);



        Event entity =repo.read(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);



        Event updateEntity = new Event.Builder()
                .copy(entity)
                .tagline("#ZIYAWA")
                .build();
        repo.update(updateEntity);
        Event newEntity = repo.read(id);
        Assert.assertEquals(TAG + " UPDATE AN ENTITY","#ZIYAWA", newEntity.getTagline());


        repo.delete(updateEntity);
        Event deleteEntity = repo.read(id);
        Assert.assertNull(TAG + " DELETE", deleteEntity);
    }

}
