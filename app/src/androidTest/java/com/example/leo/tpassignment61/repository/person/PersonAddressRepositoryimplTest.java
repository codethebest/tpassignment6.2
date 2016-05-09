package com.example.leo.tpassignment61.repository.person;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.person.PersonAddress;
import com.example.leo.tpassignment61.domain.person.PersonContact;
import com.example.leo.tpassignment61.repository.person.impl.PersonAddressRepositoryimpl;

import org.junit.Assert;
import java.util.Set;
/**
 * Created by Leo on 4/25/2016.
 */
public class PersonAddressRepositoryimplTest extends AndroidTestCase{


    private static final String TAG ="PERSONContact TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        PersonAddressRepository repo = new PersonAddressRepositoryimpl(this.getContext());
        PersonAddress createEntity = new PersonAddress.Builder()
                .street("16 Satellite drive")
                .sub("Kwezi park")
                .city("Cape Town")
                .country("South Africa")
                .build();
        PersonAddress insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);


        Set<PersonAddress> personSet = repo.readAll();
        Assert.assertTrue(TAG + " READ ALL", personSet.size() > 0);


        PersonAddress entity = repo.read(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        PersonAddress updateEntity = new PersonAddress.Builder()
                .copy(entity)
                .sub("Kwezi Park")
                .build();
        repo.update(updateEntity);
        PersonAddress newEntity = repo.read(id);
        Assert.assertEquals(TAG + " UPDATE AN ENTITY", "Kwezi Park", newEntity.getSub());


        repo.delete(updateEntity);
        PersonAddress deleteEntity = repo.read(id);
        Assert.assertNull(TAG + " DELETE", deleteEntity);
    }
}
