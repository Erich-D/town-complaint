package com.project2.town.complaint.repository;

import com.project2.town.complaint.entity.Meeting;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMeetingRepository {
    @Autowired
    MeetingRepository mr;

    @BeforeAll
    public void setUp(){
        Meeting m1 = new Meeting(-1l,"here or there",25687l,"too many jokers");
        Meeting m2 = new Meeting(-2l,"there or here",25635l,"not enough jokers");
        mr.save(m1);
        mr.save(m2);
    }
    @Test
    public void testNewMeeting(){
        Meeting newMeeting = new Meeting();
        newMeeting.setAddress("town square");
        Assertions.assertEquals("town square",mr.save(newMeeting).getAddress());
        Assertions.assertTrue(mr.save(newMeeting).getMeeting_id()>2);
    }
    @Test
    public void testGetMeetings(){
        List<Meeting> meetings = mr.findAll();
        Assertions.assertTrue(meetings.size()>1);
    }

    @Test
    public void testGetById(){
        Assertions.assertEquals(2,mr.findById(2l).get().getMeeting_id());
    }

    @Test
    public void testUpdate(){
        Meeting mtu = mr.findById(2l).get();
        mtu.setAddress("central park");
        mr.save(mtu);
        Assertions.assertEquals("central park",mr.findById(2l).get().getAddress());
    }

    @Test
    public void testDelete(){
        mr.deleteById(1l);
        Assertions.assertFalse(mr.existsById(1l));
    }
}
