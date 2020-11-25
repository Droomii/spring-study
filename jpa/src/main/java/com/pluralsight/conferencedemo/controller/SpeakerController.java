package com.pluralsight.conferencedemo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pluralsight.conferencedemo.model.Speaker;
import com.pluralsight.conferencedemo.repository.SpeakersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakersRepository speakersRepository;

    @GetMapping
    public List<Speaker> list(){
        System.out.println("accessed list");
        List<Speaker> res = speakersRepository.findAll();
        if(res==null){
            res = new ArrayList<>();
        }
        return res;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakersRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return speakersRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker){
        Speaker existingSpeaker = speakersRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
        return speakersRepository.saveAndFlush(existingSpeaker);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakersRepository.deleteById(id);
    }

}
