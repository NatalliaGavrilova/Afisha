package com.gmail.natalliagavrilova.event.dto.concert;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmail.natalliagavrilova.event.dao.entity.StatusEnum;
import com.gmail.natalliagavrilova.event.dao.entity.TypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.UUID;

public class ConcertCreate {
    private LocalDateTime dtEvent;
    private LocalDateTime dtEndOfSale;
    private String title;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private TypeEnum type;
    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;
    private UUID category;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ConcertCreate(@JsonProperty(value = "title", required = true) String title,
                         @JsonProperty(value = "description", required = true) String description,
                         @JsonProperty(value = "dt_event", required = true) LocalDateTime dtEvent,
                         @JsonProperty(value = "dt_end_of_sale", required = true) LocalDateTime dtEndOfSale,
                         @JsonProperty(value = "type", required = true) TypeEnum type,
                         @JsonProperty(value = "status", required = true) StatusEnum status,
                         @JsonProperty(value = "county", required = true) UUID category) {


        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.category = category;

    }

    public LocalDateTime getDtEvent() {
        return dtEvent;
    }

    public void setDtEvent(LocalDateTime dtEvent) {
        this.dtEvent = dtEvent;
    }

    public LocalDateTime getDtEndOfSale() {
        return dtEndOfSale;
    }

    public void setDtEndOfSale(LocalDateTime dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
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

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }
}