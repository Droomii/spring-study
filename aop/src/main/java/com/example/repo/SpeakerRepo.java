package com.example.repo;

import com.example.model.Speaker;

import java.util.List;

public interface SpeakerRepo {
    List<Speaker> findAll();
}
