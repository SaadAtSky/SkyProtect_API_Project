package com.sky.events_api_project.controller;

import com.sky.events_api_project.entity.Event;
import com.sky.events_api_project.service.EventsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventsControllerUnitTest {
    @InjectMocks
    EventsController eventsController;

    @Mock
    EventsService eventsService;

    @Test
    public void givenPostRequestForEvent_whenProcessed_thenReturnEvent(){
        Event expectedEvent = new Event();
        when(eventsService.addEvent(any())).thenReturn(new ResponseEntity<>(expectedEvent,HttpStatus.OK));
        ResponseEntity<Event> responseEntity = eventsController.addEvent(any());
        assertThat(responseEntity.getBody()).isEqualTo(expectedEvent);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void givenPutRequestForEvent_whenProcessed_thenReturnEvent(){
        Event expectedEvent = new Event();
        when(eventsService.updateEvent(any())).thenReturn(new ResponseEntity<>(expectedEvent,HttpStatus.OK));
        ResponseEntity<Event> responseEntity = eventsController.updateEvent(any());
        assertThat(responseEntity.getBody()).isEqualTo(expectedEvent);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void givenGetRequestWithUUID_whenProcessed_thenReturnEvent(){
        Event expectedEvent = new Event();
        when(eventsService.getEventByUUID(any())).thenReturn(new ResponseEntity<>(expectedEvent,HttpStatus.OK));
        ResponseEntity<Event> responseEntity = eventsController.getEventByUUID(any());
        assertThat(responseEntity.getBody()).isEqualTo(expectedEvent);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
