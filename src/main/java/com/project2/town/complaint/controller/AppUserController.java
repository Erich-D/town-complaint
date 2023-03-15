package com.project2.town.complaint.controller;

import com.project2.town.complaint.entity.AppUser;
import com.project2.town.complaint.entity.Meeting;
import com.project2.town.complaint.service.AppUserService;
import com.project2.town.complaint.utils.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping
    public AppUser insert(@RequestBody AppUser appUser){
        return appUserService.insert(appUser);
    }

    @PatchMapping
    public AppUser getUser(@RequestBody Login login){
        return appUserService.getByNameAndPassword(login);
    }
}
