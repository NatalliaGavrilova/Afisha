package com.gmail.natalliagavrilova.event.dto.film;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmail.natalliagavrilova.event.dao.entity.StatusEnum;
import com.gmail.natalliagavrilova.event.dao.entity.TypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class FilmCreate implements Serializable {


    private LocalDateTime dtEvent;
    private LocalDateTime dtEndOfSale;
    private String title;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private TypeEnum type;
    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;
    private UUID country;
    private long releaseYear;
    private LocalDateTime releaseDate;
    private long duration;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FilmCreate(@JsonProperty(value = "title", required = true)String title,
                       @JsonProperty(value = "description", required = true)String description,
                       @JsonProperty(value = "dt_event", required = true)LocalDateTime dtEvent,
                       @JsonProperty(value = "dt_end_of_sale", required = true)LocalDateTime dtEndOfSale,
                       @JsonProperty(value = "type", required = true) TypeEnum type,
                       @JsonProperty(value = "status", required = true)StatusEnum status,
                      @JsonProperty(value = "county", required = true)UUID country,
                       @JsonProperty(value = "release_year", required = true)long releaseYear,
                       @JsonProperty(value = "release_date", required = true)LocalDateTime releaseDate,
                       @JsonProperty(value = "duration", required = true)long duration) {


        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.country  = country;
        this.releaseYear = releaseYear;
        this.releaseDate = releaseDate;
        this.duration = duration;
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

    public UUID getCountry() {
        return country;
    }

    public void setCountry(UUID country) {
        this.country = country;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
