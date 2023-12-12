package com.sky.events_api_project.repository;

import com.sky.events_api_project.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event,String> {
}
