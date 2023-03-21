package com.project2.town.complaint.controller;

import com.project2.town.complaint.entity.AppUser;
import com.project2.town.complaint.entity.Meeting;
import com.project2.town.complaint.service.AppUserService;
import com.project2.town.complaint.utils.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://town-complaint-front-end.s3-website-us-west-1.amazonaws.com")
@RestController
@RequestMapping("/login")
public class AppUserController {

    @Autowired
    AppUserService appUserService;
    Logger logger1 = LoggerFactory.getLogger(AppUserController.class);

    @PostMapping
    public AppUser insert(@RequestBody AppUser appUser){
        return appUserService.insert(appUser);
    }

    @PatchMapping
    public ResponseEntity<AppUser> getUser(@RequestBody Login login){
        try {
            logger1.info("user logging in");
            return new ResponseEntity<AppUser>(appUserService.getByNameAndPassword(login), HttpStatus.OK);
        }catch(Exception e){
            logger1.error("No user found");
            return new ResponseEntity<AppUser>(new AppUser(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
