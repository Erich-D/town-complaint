package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.Meeting;

import java.util.List;

public interface MeetingService {
    Meeting insert(Meeting meeting);
    Meeting getById(long id);
    List<Meeting> getAll();
    Meeting update(Meeting meeting);
    boolean delete(long id);
}
