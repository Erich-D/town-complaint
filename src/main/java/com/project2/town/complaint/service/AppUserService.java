package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.AppUser;
import com.project2.town.complaint.utils.Login;

import java.util.List;

public interface AppUserService {
    AppUser insert(AppUser appUser);
    AppUser getByNameAndPassword(Login login);
    AppUser getById(long id);
    List<AppUser> getAll();
    AppUser update(AppUser appUser);
    boolean delete(long id);
}
