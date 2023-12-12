package com.sky.events_api_project.service;

import com.sky.events_api_project.entity.Event;
import com.sky.events_api_project.repository.EventsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EventsService {
    private final EventsRepository eventsRepository;

    public ResponseEntity<Event> addEvent(Event event){
        try{
            return new ResponseEntity<>(eventsRepository.save(event), HttpStatus.valueOf(200));
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public ResponseEntity<Event> updateEvent(String uuid){
        try{
            Optional<Event> event = eventsRepository.findById(uuid);
            if(event.isPresent()){
                if (!event.get().getNotification_sent()){
                    event.get().setNotification_sent(true);
                    return new ResponseEntity<>(eventsRepository.save(event.get()),HttpStatus.OK);
                }
                else return new ResponseEntity<>(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("failed to update as notification is already sent").getStatusCode());
            }
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
