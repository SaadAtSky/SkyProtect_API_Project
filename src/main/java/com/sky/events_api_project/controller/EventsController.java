package com.sky.events_api_project.controller;

import com.sky.events_api_project.service.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EventsController {
    private final EventsService eventsService;
}
