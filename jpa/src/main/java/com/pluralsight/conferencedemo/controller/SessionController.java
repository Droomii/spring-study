package com.pluralsight.conferencedemo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pluralsight.conferencedemo.model.Session;
import com.pluralsight.conferencedemo.repository.SessionsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionsRepository sessionsRepository;

    @GetMapping
    public List<Session> list() {
        return sessionsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionsRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionsRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also need to check for children records before deleting.
        sessionsRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {

        Session existingSession = sessionsRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionsRepository.saveAndFlush(existingSession);
    }
}
