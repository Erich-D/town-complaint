package com.project2.town.complaint.controller;

import com.project2.town.complaint.dto.MeetingDTO;
import com.project2.town.complaint.entity.Meeting;
import com.project2.town.complaint.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/meetings")
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @PostMapping
    public ResponseEntity<Meeting> insert(@RequestBody MeetingDTO rMeeting){
        Meeting meeting = new Meeting();
        meeting.setAddress(rMeeting.getAddress());
        meeting.setTime(rMeeting.getTime());
        meeting.setSummary(rMeeting.getSummary());
        return new ResponseEntity<>(meetingService.insert(meeting), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Meeting> getAll(){
        return meetingService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getById(@PathVariable("id") Long identifier){
        try {
            return new ResponseEntity<>(meetingService.getById(identifier),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Meeting(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Meeting> update(@RequestBody MeetingDTO rMeeting){
        try {
            Meeting meeting = new Meeting();
            meeting.setMeeting_id(rMeeting.getMeeting_id());
            meeting.setAddress(rMeeting.getAddress());
            meeting.setTime(rMeeting.getTime());
            meeting.setSummary(rMeeting.getSummary());
            return new ResponseEntity<>(meetingService.update(meeting),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Meeting(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{deleteId}")
    public boolean delete(@PathVariable("deleteId") Long id){
        return meetingService.delete(id);
    }
}
