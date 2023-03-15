package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.Complaint;
import com.project2.town.complaint.repository.ComplaintRepository;
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
public class ComplaintServiceTest {
    @MockBean(ComplaintRepository.class)
    private ComplaintRepository cr;
    @Autowired
    ComplaintServiceImp cs;

    @Test
    public void testInsert(){
        Complaint m1 = new Complaint(-1l,"too many villains","UNREVIEWED",1l);
        Complaint m2 = new Complaint(5l,"not enough villains","UNREVIEWED",2l);
        Mockito.when(cr.save(m1)).thenReturn(m2);
        Assertions.assertEquals(m2,cs.insert(m1));
    }

    @Test
    public void testGetById(){
        Complaint m1 = new Complaint(6l,"too many villains","UNREVIEWED",1l);
        Mockito.when(cr.findById(6l)).thenReturn(Optional.of(m1));
        Assertions.assertEquals(m1,cs.getById(6l));
    }

    @Test
    public void testGetAll(){
        List<Complaint> complaints = new ArrayList<>(){{
            Complaint m1 = new Complaint(-1l,"too many villains","UNREVIEWED",1l);
            Complaint m2 = new Complaint(5l,"not enough villains","UNREVIEWED",2l);
            Complaint m3 = new Complaint(5l,"too many whiners","UNREVIEWED",2l);
        }};
        Mockito.when(cr.findAll()).thenReturn(complaints);
        Assertions.assertEquals(complaints,cs.getAll());
    }

    @Test
    public void testUpdate(){
        Complaint m1 = new Complaint(5l,"too many villains","UNREVIEWED",1l);
        Complaint m2 = new Complaint(5l,"not enough villains","UNREVIEWED",1l);
        Mockito.when(cr.save(m1)).thenReturn(m2);
        Assertions.assertEquals(m2,cs.update(m1));
    }

    @Test
    public void testDelete(){
        Mockito.when(cr.existsById((long)5)).thenReturn(true);
        Mockito.when(cr.existsById((long)9)).thenReturn(false);
        Assertions.assertTrue(cs.delete((long)5));
        Assertions.assertFalse(cs.delete((long)9));
    }

    @Test
    public void testGetByStatus(){
        List<Complaint> complaints = new ArrayList<>(){{
            Complaint m1 = new Complaint(6l,"too many villains","UNREVIEWED",1l);
            Complaint m2 = new Complaint(5l,"not enough villains","IGNORED",2l);
            Complaint m3 = new Complaint(7l,"too many whiners","UNREVIEWED",2l);
        }};
        List<Complaint> rcomplaints = new ArrayList<>(){{
            Complaint m1 = new Complaint(6l,"too many villains","UNREVIEWED",1l);
            Complaint m3 = new Complaint(7l,"too many whiners","UNREVIEWED",2l);
        }};
        Mockito.when(cr.findByStatus("UNREVIEWED")).thenReturn(rcomplaints);
        Assertions.assertEquals(rcomplaints,cs.getAll("UNREVIEWED"));
    }

}
