package com.project2.town.complaint.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long complaint_id;
    @Column
    private String description;
    @Column
    private String status;
    @Column
    private Long meeting_id;
}
