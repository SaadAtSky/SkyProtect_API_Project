package com.sky.events_api_project.repository;

import com.sky.events_api_project.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Event,String> {
}
