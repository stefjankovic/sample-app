package com.sjankovic.sampleapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Initiator {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private boolean notify;
    private String timeZone;
}
