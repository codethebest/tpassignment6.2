package com.example.leo.tpassignment61.repository.event;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.event.EventAddress;
import com.example.leo.tpassignment61.repository.event.impl.EventAddressRepositoryimpl;

import org.junit.Assert;

import java.util.Set;

/**
 * Created by Leo on 5/7/2016.
 */
public class EventAddressRepositoryimplTest extends AndroidTestCase
{
    private static final String TAG ="Event Contact TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        EventAddressRepository repo = new EventAddressRepositoryimpl(this.getContext());
        EventAddress createEntity = new EventAddress.Builder()
                .street("16 Satellite drive")
                .sub("Kwezi park")
                .city("Cape Town")
                .country("South Africa")
                .build();
        EventAddress insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);


        Set<EventAddress> personSet = repo.readAll();
        Assert.assertTrue(TAG + " READ ALL", personSet.size() > 0);


        EventAddress entity = repo.read(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        EventAddress updateEntity = new EventAddress.Builder()
                .copy(entity)
                .sub("Kwezi Park")
                .build();
        repo.update(updateEntity);
        EventAddress newEntity = repo.read(id);
        Assert.assertEquals(TAG + " UPDATE AN ENTITY", "Kwezi Park", newEntity.getSub());


        repo.delete(updateEntity);
        EventAddress deleteEntity = repo.read(id);
        Assert.assertNull(TAG + " DELETE", deleteEntity);
    }
}
