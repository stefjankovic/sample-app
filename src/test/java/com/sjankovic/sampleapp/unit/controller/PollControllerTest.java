package com.sjankovic.sampleapp.unit.controller;

import com.sjankovic.sampleapp.controller.PollController;
import com.sjankovic.sampleapp.entities.Poll;
import com.sjankovic.sampleapp.service.PollService;
import com.sjankovic.sampleapp.unit.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(PollController.class)
public class PollControllerTest {

    private static final String POLL_CONTROLLER_PATH = "/api/v1/polls";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PollService pollService;

    List<Poll> polls = List.of(TestUtils.createPoll());

    @Test
    public void getPollsByInitiator() throws Exception {
        Mockito.when(pollService.getPollsCreatedByUser(Mockito.anyString())).thenReturn(polls);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(POLL_CONTROLLER_PATH + "/initiator")
                .param("initiatorEmail","Qui sont les superhéros Marvel les plus oufs?")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(TestUtils.getTestJSONPollAsString(), false));
    }
}
