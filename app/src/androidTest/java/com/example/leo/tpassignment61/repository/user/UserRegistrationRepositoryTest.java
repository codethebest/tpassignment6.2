package com.example.leo.tpassignment61.repository.user;

import android.test.AndroidTestCase;
import java.util.Set;
import com.example.leo.tpassignment61.domain.user.UserRegistration;
import com.example.leo.tpassignment61.repository.user.impl.UserRegistrationRepositoryImp;

import junit.framework.Assert;

/**
 * Created by Leo on 4/24/2016.
 */
public class UserRegistrationRepositoryTest extends AndroidTestCase{

    private static final String TAG = "UserRegistration Test";
    private Long id;
    private UserRegistrationRepository repo;
    public void testCreateReadUpdateDelete()throws Exception {
        repo = new UserRegistrationRepositoryImp(this.getContext());
        //**********************Create**************************************************
       UserRegistration createEntity = new UserRegistration.Builder()
               .gender("Male")
                .name("Liyolo")
                .useremail("Leo.moko@gmail.com")
                .newPassword("2566")
                .build();
        UserRegistration insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " Create", insertedEntity);

        //*********************Read All************************************
        Set<UserRegistration> userRegistrationSet = repo.readAll();
        Assert.assertTrue(TAG + " READ ALL", userRegistrationSet.size() > 0);

        //**********************Read Entity*********************
        UserRegistration entity = repo.read(id);
        Assert.assertNotNull(TAG +" READ ENTITY",entity);


        //**********************Update Entity*******************
        UserRegistration updateEntity = new UserRegistration.Builder()
                .copy(entity)
                .newPassword("LiyoloMoko34")
                .build();
        repo.update(updateEntity);
        UserRegistration newEntity = repo.read(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "LiyoloMoko34", newEntity.getNewPassword());


        //**********************Delete Entity*******************
        repo.delete(updateEntity);
        UserRegistration deleteEntity = repo.read(id);
        Assert.assertNull(TAG+" DELETE",deleteEntity);
    }
}
