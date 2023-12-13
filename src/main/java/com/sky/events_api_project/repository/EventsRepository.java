package com.sky.events_api_project.repository;

import com.sky.events_api_project.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Event,String> {
    @Query(value = "SELECT * FROM event WHERE notification_sent = ?1", nativeQuery = true)
    List<Event> filterByNotificationSent(Boolean notificationSent);

    @Query(value = "SELECT * FROM event WHERE is_deleted = ?1", nativeQuery = true)
    List<Event> filterByIsDeleted(Boolean isDeleted);

    @Query(value = "SELECT * FROM event WHERE notification_sent = ?1 AND is_deleted = ?2", nativeQuery = true)
    List<Event> filterByNotificationSentAndIsDeleted(Boolean notificationSent, Boolean isDeleted);
}
