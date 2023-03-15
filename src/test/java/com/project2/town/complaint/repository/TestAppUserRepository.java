package com.project2.town.complaint.repository;

import com.project2.town.complaint.entity.AppUser;
import com.project2.town.complaint.entity.Complaint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAppUserRepository {

    @Autowired
    AppUserRepository aur;

    @BeforeAll
    public void setUp(){
        AppUser m1 = new AppUser(-1l,"adamGator","pass123","COUNCIL");
        AppUser m2 = new AppUser(-2l,"patrick99","pat1","CONSTITUENT");
        AppUser m3 = new AppUser(-2l,"joeCool","camelskillyou","CONSTITUENT");
        aur.save(m1);
        aur.save(m2);
        aur.save(m3);
    }

    @Test
    public void testNewUser(){
        AppUser newAppUser = new AppUser();
        newAppUser.setUsername("joeDoe");
        newAppUser.setPassword("superpassword");
        Assertions.assertEquals("superpassword",aur.save(newAppUser).getPassword());
        Assertions.assertTrue(aur.save(newAppUser).getUser_id()>2);
    }

    @Test
    public void testGetAll(){
        Assertions.assertTrue(aur.findAll().size()>0);
    }

    @Test
    public void testGetById(){
        Assertions.assertEquals(2l,aur.findById(2l).get().getUser_id());
    }

    @Test
    public void testUpdate(){
        AppUser updateUser = aur.findById(1l).get();
        updateUser.setPassword("ultimatePassword");
        aur.save(updateUser);
        Assertions.assertEquals("ultimatePassword",aur.findById(1l).get().getPassword());
    }

    @Test
    public void testDelete(){
        aur.deleteById(3l);
        Assertions.assertFalse(aur.existsById(3l));
    }

    @Test
    public void testGetByNameAndPassword(){
        AppUser user = aur.findByUsernameAndPassword("patrick99", "pat1");
        Assertions.assertEquals("patrick99",user.getUsername());
        Assertions.assertEquals("pat1",user.getPassword());
        Assertions.assertEquals("CONSTITUENT",user.getRole());
    }
}
