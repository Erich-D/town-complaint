package com.project2.town.complaint.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long meeting_id;
    @Column
    private String address;
    @Column
    private Long time;// unix epoc time
    @Column
    private String summary;

}
