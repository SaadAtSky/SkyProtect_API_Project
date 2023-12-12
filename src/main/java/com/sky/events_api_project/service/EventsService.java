package com.sky.events_api_project.service;

import com.sky.events_api_project.entity.Event;
import com.sky.events_api_project.repository.EventsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class EventsService {
    private final EventsRepository eventsRepository;

    public ResponseEntity<Event> addEvent(Event event){
        try{
            eventsRepository.save(event);
            return new ResponseEntity<>(eventsRepository.save(event), HttpStatus.valueOf(200));
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
