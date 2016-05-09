package com.example.leo.tpassignment61.repository.person;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.person.PersonContact;
import com.example.leo.tpassignment61.repository.person.impl.PersonContactRepositoryimpl;

import org.junit.Assert;
import java.util.Set;
/**
 * Created by Leo on 4/25/2016.
 */
public class PersonContactReposotoryimpTest extends AndroidTestCase {

    private static final String TAG ="PERSONContact TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        PersonContactRepository repo = new PersonContactRepositoryimpl(this.getContext());
        PersonContact createEntity = new PersonContact.Builder()
                .screenName("Liyolo")
                .website("www.moko.com")
                .email("leo.moko8@gmail.com")
                .build();
        PersonContact insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);


        Set<PersonContact> personSet = repo.readAll();
        Assert.assertTrue(TAG + " READ ALL", personSet.size() > 0);


        PersonContact entity = repo.read(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        PersonContact updateEntity = new PersonContact.Builder()
                .copy(entity)
                .email("leo.moko8@gmail.com")
                .build();
        repo.update(updateEntity);
        PersonContact newEntity = repo.read(id);
        Assert.assertEquals(TAG + " UPDATE AN ENTITY", "leo.moko8@gmail.com", newEntity.getEmail());


        repo.delete(updateEntity);
        PersonContact deleteEntity = repo.read(id);
        Assert.assertNull(TAG + " DELETE", deleteEntity);
    }
}
