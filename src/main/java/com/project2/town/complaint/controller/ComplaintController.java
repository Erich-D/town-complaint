package com.project2.town.complaint.controller;

import com.project2.town.complaint.dto.ComplaintDTO;
import com.project2.town.complaint.entity.Complaint;
import com.project2.town.complaint.service.ComplaintService;
import com.project2.town.complaint.utils.NumCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/complaints")
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<Complaint> insert(@RequestBody ComplaintDTO rComplaint){
            Complaint complaint = new Complaint();
            complaint.setDescription(rComplaint.getDescription());
            complaint.setStatus(rComplaint.getStatus());
            complaint.setMeeting_id(rComplaint.getMeeting_id());
            return new ResponseEntity<>(complaintService.insert(complaint), HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Complaint> getAll(@RequestParam(required = false, value = "status") String flag, @RequestParam(required = false, value="id") String id){
        if(flag==null&&id==null)return complaintService.getAll();
        else if (id!=null && NumCheck.isNumeric(id)) {
            return complaintService.getAll(Long.parseLong(id));
        } else return complaintService.getAll(flag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getById(@PathVariable("id") Long identifier){
        try {
            return new ResponseEntity<>(complaintService.getById(identifier),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Complaint(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Complaint> update(@RequestBody ComplaintDTO rComplaint){
        try {
            Complaint complaint = new Complaint();
            complaint.setComplaint_id(rComplaint.getComplaint_id());
            complaint.setDescription(rComplaint.getDescription());
            complaint.setStatus(rComplaint.getStatus());
            complaint.setMeeting_id(rComplaint.getMeeting_id());
            return new ResponseEntity<>(complaintService.update(complaint),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Complaint(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{deleteId}")
    public boolean delete(@PathVariable("deleteId") Long id){
        return complaintService.delete(id);
    }
}
