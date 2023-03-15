package com.project2.town.complaint.controller;

import com.project2.town.complaint.entity.Meeting;
import com.project2.town.complaint.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/meetings")
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @PostMapping
    public Meeting insert(@RequestBody Meeting meeting){
        return meetingService.insert(meeting);
    }

    @GetMapping()
    public List<Meeting> getAll(){
        return meetingService.getAll();
    }

    @GetMapping("/{id}")
    public Meeting getById(@PathVariable("id") Long identifier){
        return meetingService.getById(identifier);
    }

    @PutMapping()
    public Meeting update(@RequestBody Meeting meeting){
        return meetingService.update(meeting);
    }

    @DeleteMapping("/{deleteId}")
    public boolean delete(@PathVariable("deleteId") Long id){
        return meetingService.delete(id);
    }
}
