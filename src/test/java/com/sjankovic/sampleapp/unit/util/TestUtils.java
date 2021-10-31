package com.sjankovic.sampleapp.unit.util;

import com.sjankovic.sampleapp.entities.Initiator;
import com.sjankovic.sampleapp.entities.Participant;
import com.sjankovic.sampleapp.entities.Poll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TestUtils {

    public static final String INITIATOR_EMAIL_TEST_EXAMPLE = "mh+sample@doodle.com";

    public static Poll createPoll() {
        Poll poll = new Poll();
        poll.setId("xsd4cv89t5f5um4b");
        poll.setAdminKey("r44d7piq");
        poll.setLatestChange(1485521573482L);
        poll.setInitiated(1485521569056L);
        poll.setParticipantsCount(4);
        poll.setInviteesCount(0);
        poll.setType("TEXT");
        poll.setHidden(true);
        poll.setPreferencesType("YESNO");
        poll.setState("OPEN");
        poll.setLocale("fr_CH");
        poll.setTitle("Qui sont les superhéros Marvel les plus oufs?");
        poll.setInitiator(createInitiator());
        poll.setOptions(createOptions());
        poll.setOptionsHash("509166a0b12ed8e4ec658f0060aaf38e");
        poll.setParticipants(createParticipants());
        poll.setInvitees(new ArrayList<>());
        poll.setDevice("WEB");
        poll.setLevels("YESNO");

        return poll;
    }

    private static List<Participant> createParticipants() {
        List<Participant> participants = new ArrayList<>();

        Participant participant1 = new Participant();
        participant1.setId(1722022335L);
        participant1.setName("Ringo");
        participant1.setPreferences(Arrays.asList(1, 0, 0, 1, 1, 0, 0, 0));
        participants.add(participant1);

        Participant participant2 = new Participant();
        participant2.setId(1873740236L);
        participant2.setName("George");
        participant2.setPreferences(Arrays.asList(1, 0, 1, 0, 1, 1, 0, 1));
        participants.add(participant2);

        Participant participant3 = new Participant();
        participant3.setId(1035270451L);
        participant3.setName("John");
        participant3.setPreferences(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 1));
        participants.add(participant3);

        Participant participant4 = new Participant();
        participant4.setId(25195396L);
        participant4.setName("Paul");
        participant4.setPreferences(Arrays.asList(1, 1, 0, 1, 0, 1, 1, 1));
        participants.add(participant4);

        return participants;
    }

    private static List<Map<String, Object>> createOptions() {
        List<Map<String, Object>> options = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("text", "Spider-Man");
        map1.put("available", true);
        options.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("text", "Captain Marvel");
        map2.put("available", true);
        options.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("text", "Hulk");
        map3.put("available", true);
        options.add(map3);

        Map<String, Object> map4 = new HashMap<>();
        map4.put("text", "Thor");
        map4.put("available", true);
        options.add(map4);

        Map<String, Object> map5 = new HashMap<>();
        map5.put("text", "Iron Man");
        map5.put("available", true);
        options.add(map5);

        Map<String, Object> map6 = new HashMap<>();
        map6.put("text", "Luke Cage");
        map6.put("available", true);
        options.add(map6);

        Map<String, Object> map7 = new HashMap<>();
        map7.put("text", "Black Widow");
        map7.put("available", true);
        options.add(map7);

        Map<String, Object> map8 = new HashMap<>();
        map8.put("text", "Daredevil");
        map8.put("available", true);
        options.add(map8);

        return options;
    }

    private static Initiator createInitiator() {
        Initiator initiator = new Initiator();
        initiator.setName("John Doe");
        initiator.setEmail("mh+sample@doodle.com");
        initiator.setNotify(false);
        return initiator;
    }

    public static String getTestJSONPollAsString() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/testPoll.json")));
    }
}