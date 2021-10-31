package com.sjankovic.sampleapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Poll {

    @Id
    private String id;
    private String adminKey;
    private long latestChange;
    private long initiated;
    private int participantsCount;
    private int inviteesCount;
    private String type;
    private boolean timeZone;
    private int columnConstraint;
    private int rowConstraint;
    private boolean hidden;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;
    @Column(length = 1024)
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private Initiator initiator;
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private List<Map<String, Object>> options;
    private String optionsHash;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participants;
    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    private List<String> invitees;
    private boolean multiDay;
    private boolean dateText;
    private String device;
    private String levels;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
}
