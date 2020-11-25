package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakersRepository extends JpaRepository<Speaker, Long> {


}
