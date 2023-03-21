package com.project2.town.complaint.service;

import com.project2.town.complaint.entity.AppUser;
import com.project2.town.complaint.exceptions.NoSuchUserException;
import com.project2.town.complaint.repository.AppUserRepository;
import com.project2.town.complaint.utils.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImp implements AppUserService{
    @Autowired
    AppUserRepository appUserRepository;
    @Override
    public AppUser insert(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser getByNameAndPassword(Login login)throws NoSuchUserException{
        AppUser result = null;
        try {
            result = appUserRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
            result.setPassword(result.getPassword().replaceAll(".", "*"));
        }catch(NullPointerException ne){
            throw new NoSuchUserException();
        }

        return result;
    }

    @Override
    public AppUser getById(long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public boolean delete(long id) {
        boolean found = appUserRepository.existsById(id);
        if(found) appUserRepository.deleteById(id);
        return found;
    }
}
