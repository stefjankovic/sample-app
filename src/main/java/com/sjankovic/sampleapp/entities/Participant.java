package com.sjankovic.sampleapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    private Long id;
    private String name;
    @Type(type = "list-array")
    @Column(
            columnDefinition = "integer[]"
    )
    private List<Integer> preferences;
}
