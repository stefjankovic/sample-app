package com.sjankovic.sampleapp.repository;

import com.sjankovic.sampleapp.entities.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends CrudRepository<Poll, String> {
    List<Poll> getPollsByInitiatorEmail(String email);
    List<Poll> getPollsByTitle(String title);
    List<Poll> getPollsByInitiatedIsLessThan(long dateTimeMillis);
}
