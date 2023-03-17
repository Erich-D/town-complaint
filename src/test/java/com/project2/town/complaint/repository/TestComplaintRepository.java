package com.project2.town.complaint.repository;

import com.project2.town.complaint.entity.Complaint;
import com.project2.town.complaint.entity.Meeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestComplaintRepository {
    @Autowired
    ComplaintRepository cr;

    @BeforeAll
    public void setUp(){
        Complaint m1 = new Complaint(-1l,"too many villains","UNREVIEWED",1l);
        Complaint m2 = new Complaint(-2l,"not enough villains","UNREVIEWED",2l);
        Complaint m3 = new Complaint(5l,"not enough parks","IGNORED",5l);
        cr.save(m1);
        cr.save(m2);
        cr.save(m3);
    }

    @Test
    public void testNewMeeting(){
        Complaint newComplaint = new Complaint();
        newComplaint.setDescription("town square too small");
        newComplaint.setStatus("High Priority");
        Assertions.assertEquals("town square too small",cr.save(newComplaint).getDescription());
        Assertions.assertTrue(cr.save(newComplaint).getComplaint_id()>2);
    }
    @Test
    public void testGetMeetings(){
        List<Complaint> complaints = cr.findAll();
        Assertions.assertTrue(complaints.size()>1);
    }

    @Test
    public void testGetById(){
        Assertions.assertEquals(2,cr.findById(2l).get().getMeeting_id());
    }

    @Test
    public void testUpdate(){
        Complaint ctu = cr.findById(2l).get();
        ctu.setStatus("Ignored");
        cr.save(ctu);
        Assertions.assertEquals("Ignored",cr.findById(2l).get().getStatus());
    }

    @Test
    public void testDelete(){
        cr.deleteById(1l);
        Assertions.assertFalse(cr.existsById(1l));
    }

    @Test
    public void testGetByStatus(){
        List<Complaint> complaints = cr.findByStatus("UNREVIEWED");
        Assertions.assertEquals(2,complaints.size());
    }

    @Test
    public void testGetByMeeting_Id(){
        List<Complaint> complaints = cr.findByMeetingId(5l);
        Assertions.assertEquals(1,complaints.size());
    }
}
