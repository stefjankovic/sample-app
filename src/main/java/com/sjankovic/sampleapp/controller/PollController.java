package com.sjankovic.sampleapp.controller;

import com.sjankovic.sampleapp.entities.Poll;
import com.sjankovic.sampleapp.service.PollService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController {

    private PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @RequestMapping("/initiator")
    public List<Poll> getPollsByInitiator(@RequestParam String initiatorEmail) {
        return pollService.getPollsCreatedByUser(initiatorEmail);
    }

    @RequestMapping()
    public List<Poll> getPolls(@RequestParam(required = false) String title, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdFrom) {
        if (createdFrom == null && title != null && !title.isEmpty()) {
            return pollService.getPollsByTitle(title);
        }
        if ((title == null || title.isEmpty()) && createdFrom != null) {
            return pollService.getPollsCreatedAfterDate(createdFrom);
        }
        return null;
    }
}
