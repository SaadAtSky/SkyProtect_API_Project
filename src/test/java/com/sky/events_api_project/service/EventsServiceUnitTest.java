package com.sky.events_api_project.service;
import com.sky.events_api_project.entity.Event;
import com.sky.events_api_project.repository.EventsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventsServiceUnitTest {
    @InjectMocks
    EventsService eventsService;

    @Mock
    EventsRepository eventsRepository;

    @Test
    public void givenValidEvent_whenSaveToDB_thenReturnEvent(){
        Event expectedEvent = new Event();
        when(eventsRepository.save(any())).thenReturn(expectedEvent);
        ResponseEntity<Event> responseEntity = eventsService.addEvent(any());
        assertThat(responseEntity.getBody()).isEqualTo(expectedEvent);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void givenInvalidEvent_whenSaveToDB_thenReturnError(){
        when(eventsRepository.save(any())).thenThrow(new RuntimeException());
        ResponseEntity<Event> responseEntity = eventsService.addEvent(any());
        assertThat(responseEntity.getBody()).isEqualTo(null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    public void givenKnownUUID_whenUpdateDB_thenReturnEvent(){
        Event expectedEvent = new Event();
        expectedEvent.setNotification_sent(false);
        when(eventsRepository.findById(any())).thenReturn(Optional.of(expectedEvent));
        when(eventsRepository.save(any())).thenReturn(expectedEvent);
        ResponseEntity<Event> responseEntity = eventsService.updateEvent(any());
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getNotification_sent()).isEqualTo(true);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void givenUnknownUUID_whenUpdateDB_thenReturnError(){
        when(eventsRepository.findById(any())).thenReturn(Optional.empty());
        ResponseEntity<Event> responseEntity = eventsService.updateEvent(any());
        assertThat(responseEntity.getBody()).isEqualTo(null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void givenEventWithNotificationSent_whenUpdateDB_thenReturnError(){
        Event expectedEvent = new Event();
        expectedEvent.setNotification_sent(true);
        when(eventsRepository.findById(any())).thenReturn(Optional.of(expectedEvent));
        ResponseEntity<Event> responseEntity = eventsService.updateEvent(any());
        assertThat(responseEntity.getBody()).isEqualTo(null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @Test
    public void givenKnownUUID_whenSearchDB_thenReturnEvent(){
        Event expectedEvent = new Event();
        when(eventsRepository.findById(any())).thenReturn(Optional.of(expectedEvent));
        ResponseEntity<Event> responseEntity = eventsService.getEventByUUID(any());
        assertThat(responseEntity.getBody()).isEqualTo(expectedEvent);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void givenUnknownUUID_whenSearchDB_thenReturnError(){
        when(eventsRepository.findById(any())).thenReturn(Optional.empty());
        ResponseEntity<Event> responseEntity = eventsService.getEventByUUID(any());
        assertThat(responseEntity.getBody()).isEqualTo(null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void whenFindAllEventsInDB_thenReturnEventsList(){
        ArrayList<Event> expectedEventsList = new ArrayList<>(Arrays.asList(new Event(),new Event()));
        when(eventsRepository.findAll()).thenReturn(expectedEventsList);
        ResponseEntity<List<Event>> responseEntity = eventsService.getAllEvents();
        assertThat(responseEntity.getBody()).isEqualTo(expectedEventsList);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
