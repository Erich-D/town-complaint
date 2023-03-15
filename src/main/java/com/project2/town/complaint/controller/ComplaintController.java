package com.project2.town.complaint.controller;

import com.project2.town.complaint.entity.Complaint;
import com.project2.town.complaint.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/complaints")
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    @PostMapping
    public Complaint insert(@RequestBody Complaint complaint){
        return complaintService.insert(complaint);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Complaint> getAll(@RequestParam(required = false, value = "status") String flag){
        if(flag==null)return complaintService.getAll();
        else return complaintService.getAll(flag);
    }

    @GetMapping("/{id}")
    public Complaint getById(@PathVariable("id") Long identifier){
        return complaintService.getById(identifier);
    }

    @PutMapping()
    public Complaint update(@RequestBody Complaint complaint){
        return complaintService.update(complaint);
    }

    @DeleteMapping("/{deleteId}")
    public boolean delete(@PathVariable("deleteId") Long id){
        return complaintService.delete(id);
    }
}
