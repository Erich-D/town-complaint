package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.Complaint;
import com.project2.town.complaint.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImp implements ComplaintService{
    @Autowired
    ComplaintRepository complaintRepository;
    @Override
    public Complaint insert(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint getById(long id) {
        return complaintRepository.findById(id).get();
    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint update(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAll(String status) {
        return complaintRepository.findByStatus(status);
    }

    public List<Complaint> getAll(Long meeting_id){
        return complaintRepository.findByMeetingId(meeting_id);
    }


    @Override
    public boolean delete(long id) {
        boolean found = complaintRepository.existsById(id);
        if(found) complaintRepository.deleteById(id);
        return found;
    }
}
