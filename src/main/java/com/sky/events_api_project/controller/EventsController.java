package com.sky.events_api_project.controller;

import com.sky.events_api_project.entity.Event;
import com.sky.events_api_project.service.EventsService;
import com.sky.events_api_project.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/event")
public class EventsController {
    private final EventsService eventsService;
    private final S3Service s3Service;

    @PostMapping("/post")
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        return eventsService.addEvent(event);
    }

    @PutMapping("/put")
    public ResponseEntity<Event> updateEvent(@RequestParam String uuid){
        return eventsService.updateEvent(uuid);
    }

    @GetMapping("/get")
    public ResponseEntity<Event> getEventByUUID(@RequestParam String uuid){
        return eventsService.getEventByUUID(uuid);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Event>> getAllEvents(@RequestParam Map<String,String> allParams){
        return eventsService.getAllEvents(allParams);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Event> deleteEvent(@RequestParam String uuid){
        return eventsService.deleteEvent(uuid);
    }

    @PostMapping("/export")
    public ResponseEntity<Event> exportEvents(@RequestBody String events, @RequestParam String bucketName, @RequestParam String fileName){
        return s3Service.exportEvents(events,bucketName,fileName);
    }
}
