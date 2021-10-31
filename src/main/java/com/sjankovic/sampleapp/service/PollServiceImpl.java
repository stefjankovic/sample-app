package com.sjankovic.sampleapp.service;


import com.sjankovic.sampleapp.entities.Poll;
import com.sjankovic.sampleapp.repository.PollRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;

    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> getPollsCreatedByUser(String initiatorEmail) {
        return pollRepository.getPollsByInitiatorEmail(initiatorEmail);
    }

    @Override
    public List<Poll> getPollsByTitle(String title) {
        return pollRepository.getPollsByTitle(title);
    }

    @Override
    public List<Poll> getPollsCreatedAfterDate(LocalDateTime dateTime) {
        return pollRepository.getPollsByInitiatedIsLessThan(dateTime.toInstant(ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now())).toEpochMilli());
    }

    @Override
    public void save(List<Poll> polls) {
        pollRepository.saveAll(polls);
    }
}
