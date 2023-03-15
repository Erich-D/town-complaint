package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.AppUser;
import com.project2.town.complaint.repository.AppUserRepository;
import com.project2.town.complaint.utils.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AppUserServiceTest {
    @MockBean(AppUserRepository.class)
    private AppUserRepository ar;
    @Autowired
    AppUserServiceImp as;

    @Test
    public void testInsert(){
        AppUser m1 = new AppUser(-1l,"adamGator","pass123","COUNCIL");
        AppUser m2 = new AppUser(5l,"adamGator","pass123","COUNCIL");
        Mockito.when(ar.save(m1)).thenReturn(m2);
        Assertions.assertEquals(m2,as.insert(m1));
    }

    @Test
    public void testGetById(){
        AppUser m1 = new AppUser(6l,"adamGator","pass123","COUNCIL");
        Mockito.when(ar.findById(6l)).thenReturn(Optional.of(m1));
        Assertions.assertEquals(m1,as.getById(6l));
    }

    @Test
    public void testGetAll(){
        List<AppUser> users = new ArrayList<>(){{
            AppUser m1 = new AppUser(5l,"adamGator","pass123","COUNCIL");
            AppUser m2 = new AppUser(9l,"patrick99","pat1","CONSTITUENT");
            AppUser m3 = new AppUser(5l,"joeCool","camelskillyou","CONSTITUENT");
        }};
        Mockito.when(ar.findAll()).thenReturn(users);
        Assertions.assertEquals(users,as.getAll());
    }

    @Test
    public void testUpdate(){
        AppUser m1 = new AppUser(5l,"adamGator","pass123","COUNCIL");
        AppUser m2 = new AppUser(5l,"adamGator","ultimatepassword","COUNCIL");
        Mockito.when(ar.save(m1)).thenReturn(m2);
        Assertions.assertEquals(m2,as.update(m1));
    }

    @Test
    public void testDelete(){
        Mockito.when(ar.existsById((long)5)).thenReturn(true);
        Mockito.when(ar.existsById((long)9)).thenReturn(false);
        Assertions.assertTrue(as.delete((long)5));
        Assertions.assertFalse(as.delete((long)9));
    }

    @Test
    public void testGetByNameAndPassword(){
        AppUser m1 = new AppUser(5l,"adamGator","pass123","COUNCIL");
        Login lg = new Login("adamGator","pass123");
        Mockito.when(ar.findByUsernameAndPassword("adamGator","pass123")).thenReturn(m1);
        AppUser m2 = as.getByNameAndPassword(lg);
        Assertions.assertEquals("adamGator",m2.getUsername());
        Assertions.assertEquals("*******",m2.getPassword());
    }

}
