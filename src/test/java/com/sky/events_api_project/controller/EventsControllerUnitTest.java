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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Test
    public void givenGetRequestForAllEvents_whenProcessed_thenReturnEventsList(){
        ArrayList<Event> expectedEventsList = new ArrayList<>(Arrays.asList(new Event(),new Event()));
        when(eventsService.getAllEvents(any())).thenReturn(new ResponseEntity<>(expectedEventsList,HttpStatus.OK));
        ResponseEntity<List<Event>> responseEntity = eventsController.getAllEvents(any());
        assertThat(responseEntity.getBody()).isEqualTo(expectedEventsList);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void givenDeleteRequestForEvent_whenProcessed_thenReturnSuccessStatus(){
        when(eventsService.deleteEvent(any())).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        ResponseEntity<Event> responseEntity = eventsController.deleteEvent(any());
        assertThat(responseEntity.getBody()).isEqualTo(null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
