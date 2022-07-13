package com.gmail.natalliagavrilova.classifier.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonDeserialize
public class CategoryRead {
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private UUID uuid;
    private String title;

    public CategoryRead(LocalDateTime dtCreate, LocalDateTime dtUpdate, UUID uuid, String title) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
        this.title = title;
    }

    public CategoryRead() {
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
}
