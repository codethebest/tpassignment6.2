package com.example.leo.tpassignment61.repository.person;

import android.test.AndroidTestCase;

import com.example.leo.tpassignment61.domain.person.Person;
import com.example.leo.tpassignment61.repository.S;
import com.example.leo.tpassignment61.repository.person.impl.PersonRepositoryimpl;
import java.util.Set;
import junit.framework.Assert;

/**
 * Created by Leo on 4/25/2016.
 */
public class PersonRepositoryimplTest extends AndroidTestCase {
    private static final String TAG ="PERSON TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception
    {
        PersonRepository repo = new PersonRepositoryimpl(this.getContext());
        Person createEntity = new Person.Builder()
                .name("Liyolo")
                .surname("Moko")
                .email("leo.moko8@gmail.com")
                .auvalue("4we")
                .build();
        Person insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);


        Set<Person> personSet = repo.readAll();
        Assert.assertTrue(TAG + " READ ALL", personSet.size() > 0);



        Person entity =repo.read(id);
        Assert.assertNotNull(TAG+ " READ ENTITY", entity);



        Person updateEntity = new Person.Builder()
                .copy(entity)
                .email("leo.moko8@gmail.com")
                .build();
        repo.update(updateEntity);
        Person newEntity = repo.read(id);
        Assert.assertEquals(TAG+ " UPDATE AN ENTITY","leo.moko8@gmail.com",newEntity.getEmail());


        repo.delete(updateEntity);
        Person deleteEntity = repo.read(id);
        Assert.assertNull(TAG+ " DELETE",deleteEntity);

    }



}
