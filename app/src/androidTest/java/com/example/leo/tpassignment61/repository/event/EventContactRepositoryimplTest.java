package com.example.leo.tpassignment61.repository.event;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.event.EventContact;
import com.example.leo.tpassignment61.repository.event.impl.EventContactRepositoryimpl;

import org.junit.Assert;

import java.util.Set;

/**
 * Created by Leo on 5/7/2016.
 */
public class EventContactRepositoryimplTest extends AndroidTestCase{
    private static final String TAG ="EventContact TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        EventContactRepository repo = new EventContactRepositoryimpl(this.getContext());
        EventContact createEntity = new EventContact.Builder()
                .website("www.moko.com")
                .email("leo.moko8@gmail.com")
                .build();
        EventContact insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        Set<EventContact> personSet = repo.readAll();
        Assert.assertTrue(TAG + " READ ALL", personSet.size() > 0);

        EventContact entity = repo.read(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        EventContact updateEntity = new EventContact.Builder()
                .copy(entity)
                .email("leo.moko8@gmail.com")
                .build();
        repo.update(updateEntity);
        EventContact newEntity = repo.read(id);
        Assert.assertEquals(TAG + " UPDATE AN ENTITY", "leo.moko8@gmail.com", newEntity.getEmail());

        repo.delete(updateEntity);
        EventContact deleteEntity = repo.read(id);
        Assert.assertNull(TAG + " DELETE", deleteEntity);
    }
}
