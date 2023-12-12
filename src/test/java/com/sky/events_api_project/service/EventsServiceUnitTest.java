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
}