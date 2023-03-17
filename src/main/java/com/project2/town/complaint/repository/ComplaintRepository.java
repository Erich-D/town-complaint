package com.project2.town.complaint.repository;

import com.project2.town.complaint.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    public List<Complaint> findByStatus(String status);

    @Query(value = "SELECT * FROM complaint WHERE meeting_id = ?1", nativeQuery = true)
    public List<Complaint> findByMeetingId(long id);
}
