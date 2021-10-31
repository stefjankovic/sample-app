package com.sjankovic.sampleapp.service;

import com.sjankovic.sampleapp.entities.Poll;

import java.time.LocalDateTime;
import java.util.List;

public interface PollService {
    List<Poll> getPollsCreatedByUser(String userEmail);
    List<Poll> getPollsByTitle(String title);
    List<Poll> getPollsCreatedAfterDate(LocalDateTime date);

    void save(List<Poll> users);
}
