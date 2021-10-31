package com.sjankovic.sampleapp.repository;

import com.sjankovic.sampleapp.entities.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
}
