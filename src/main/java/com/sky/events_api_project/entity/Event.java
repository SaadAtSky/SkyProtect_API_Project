package com.sky.events_api_project.entity;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Event {
    @Id
    @Column
    @Pattern(regexp = "^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$",message = "Not a valid UUID")
    private String uuid;

    @Column
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "not a valid date and time format")
    private String recorded_at;

    @Column
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "not a valid date and time format")
    private String received_at;

    @Column
    @NotBlank
    private String category;

    @Column
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "not a valid date and time format")
    private String created_at;

    @Column
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "not a valid date and time format")
    private String updated_at;

    @Column
    @Pattern(regexp = "^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$",message = "Not a valid UUID")
    private String device_uuid;

    @Column
    private JsonNode metadata;

    @Column(columnDefinition = "boolean default false")
    private Boolean notification_sent;

    @Column(columnDefinition = "boolean default false")
    private Boolean is_deleted;
}