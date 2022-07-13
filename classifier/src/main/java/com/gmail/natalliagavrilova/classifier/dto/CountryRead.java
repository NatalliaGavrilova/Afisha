package com.gmail.natalliagavrilova.classifier.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gmail.natalliagavrilova.classifier.utils.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.util.UUID;


public class CountryRead {

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtCreate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtUpdate;
    private UUID uuid;
    private String title;
    private String description;

    public CountryRead(LocalDateTime dtCreate,
                       LocalDateTime dtUpdate, UUID uuid, String title, String description) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
        this.title = title;
        this.description = description;
    }

    public CountryRead() {
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
