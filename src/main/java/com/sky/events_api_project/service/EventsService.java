package com.sky.events_api_project.service;

import com.sky.events_api_project.repository.EventsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class EventsService {
    private final EventsRepository eventsRepository;
}
