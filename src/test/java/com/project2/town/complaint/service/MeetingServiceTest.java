package com.project2.town.complaint.service;


import com.project2.town.complaint.entity.Meeting;
import com.project2.town.complaint.repository.MeetingRepository;
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
public class MeetingServiceTest {

    @MockBean(MeetingRepository.class)
    private MeetingRepository mr;
    @Autowired
    MeetingServiceImp ms;

    @Test
    public void testInsert(){
        Meeting m1 = new Meeting(-1l,"here or there",25687l,"too many jokers");
        Meeting m2 = new Meeting(5l,"there or here",25635l,"not enough jokers");
        Mockito.when(mr.save(m1)).thenReturn(m2);
        Assertions.assertEquals(m2,ms.insert(m1));
    }

    @Test
    public void testGetById(){
        Meeting m1 = new Meeting(6l,"here or there",25687l,"too many jokers");
        Mockito.when(mr.findById(6l)).thenReturn(Optional.of(m1));
        Assertions.assertEquals(m1,ms.getById(6l));
    }

    @Test
    public void testGetAll(){
        List<Meeting> meetings = new ArrayList<>(){{
            Meeting m1 = new Meeting(2l,"here or there",25687l,"too many jokers");
            Meeting m2 = new Meeting(5l,"there or here",25635l,"not enough jokers");
            Meeting m3 = new Meeting(6l,"town hall",25596l,"identify jokers");
        }};
        Mockito.when(mr.findAll()).thenReturn(meetings);
        Assertions.assertEquals(meetings,ms.getAll());
    }

    @Test
    public void testUpdate(){
        Meeting m1 = new Meeting(5l,"here or there",25687l,"too many jokers");
        Meeting m2 = new Meeting(5l,"there or here",25687l,"not enough jokers");
        Mockito.when(mr.save(m1)).thenReturn(m2);
        Assertions.assertEquals(m2,ms.update(m1));
    }

    @Test
    public void testDelete(){
        Mockito.when(mr.existsById((long)5)).thenReturn(true);
        Mockito.when(mr.existsById((long)9)).thenReturn(false);
        Assertions.assertTrue(ms.delete((long)5));
        Assertions.assertFalse(ms.delete((long)9));

    }

}
