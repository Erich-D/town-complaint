package com.project2.town.complaint.repository;

import com.project2.town.complaint.entity.AppUser;
import com.project2.town.complaint.utils.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsernameAndPassword(String username,String password);
}
