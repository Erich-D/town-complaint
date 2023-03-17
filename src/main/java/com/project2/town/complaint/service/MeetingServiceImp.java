package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.Meeting;
import com.project2.town.complaint.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImp implements MeetingService{
    @Autowired
    MeetingRepository meetingRepository;
    @Override
    public Meeting insert(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting getById(long id) {
        return meetingRepository.findById(id).get();
    }

    @Override
    public List<Meeting> getAll() {
        List<Meeting> result = meetingRepository.findAll();
        return result.stream().filter(m->m.getMeeting_id()>0).collect(Collectors.toList());
    }

    @Override
    public Meeting update(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public boolean delete(long id) {
        boolean found = meetingRepository.existsById(id);
        if(found) meetingRepository.deleteById(id);
        return found;
    }
}
