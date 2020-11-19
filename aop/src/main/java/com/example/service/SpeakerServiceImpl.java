package com.example.service;

import com.example.model.Speaker;
import com.example.repo.SpeakerRepo;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepo speakerRepo;

    public SpeakerServiceImpl(){}

    public SpeakerServiceImpl(SpeakerRepo speakerRepo){
        this.speakerRepo = speakerRepo;
    }

    @Override
    public List<Speaker> findAll() {
        return speakerRepo.findAll();
    }

    public void setSpeakerRepo(SpeakerRepo speakerRepo) {
        this.speakerRepo = speakerRepo;
    }
}
