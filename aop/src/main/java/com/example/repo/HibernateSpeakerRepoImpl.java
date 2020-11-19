package com.example.repo;

import com.example.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepoImpl implements SpeakerRepo {



    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();

        speaker.setFirstName("Dowoo");
        speaker.setLastName("Kim");

        speakers.add(speaker);
        return speakers;

    }
}
