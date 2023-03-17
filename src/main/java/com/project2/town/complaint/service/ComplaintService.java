package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    Complaint insert(Complaint complaint);
    Complaint getById(long id);
    List<Complaint> getAll();
    Complaint update(Complaint complaint);
    List<Complaint> getAll(String status);
    List<Complaint> getAll(Long id);
    boolean delete(long id);
}
