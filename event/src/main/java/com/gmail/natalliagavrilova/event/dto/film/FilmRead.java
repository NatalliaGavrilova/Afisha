package com.gmail.natalliagavrilova.event.dto.film;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.gmail.natalliagavrilova.event.dao.entity.StatusEnum;
import com.gmail.natalliagavrilova.event.dao.entity.TypeEnum;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonDeserialize(builder = FilmRead.FilmBuilder.class)
public class FilmRead {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    private String title;
    private String description;
    private LocalDateTime dtEvent;
    private LocalDateTime dtEndOfSale;
    private TypeEnum type;
    private StatusEnum status;
    private UUID country;


    public FilmRead(UUID uuid, LocalDateTime dtCreate,
                    LocalDateTime dtUpdate, String title,
                    String description, LocalDateTime dtEvent,
                    LocalDateTime dtEndOfSale, TypeEnum type,
                    StatusEnum status, UUID country) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.country = country;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDtEvent() {
        return dtEvent;
    }

    public LocalDateTime getDtEndOfSale() {
        return dtEndOfSale;
    }

    public TypeEnum getType() {
        return type;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public UUID getCountry(){
        return country;
    }

    public static FilmBuilder create() {
        return new FilmBuilder();
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class FilmBuilder {
        private UUID uuid;
        private LocalDateTime dtCreate;
        private LocalDateTime dtUpdate;
        private String title;
        private String description;
        private LocalDateTime dtEvent;
        private LocalDateTime dtEndOfSale;
        private TypeEnum type;
        private StatusEnum status;
        private UUID country;

        private FilmBuilder() {
        }


        public FilmBuilder setDtCreate(LocalDateTime dtCreate) {
            this.dtCreate = dtCreate;
            return this;
        }

        public FilmBuilder setDtUpdate(LocalDateTime dtUpdate) {
            this.dtUpdate = dtUpdate;
            return this;
        }

        public FilmBuilder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public FilmBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public FilmBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public FilmBuilder setDtEvent(LocalDateTime dtEvent) {
            this.dtEvent = dtEvent;
            return this;
        }

        public FilmBuilder setDtEndOfSale(LocalDateTime dtEndOfSale) {
            this.dtEndOfSale = dtEndOfSale;
            return this;
        }

        public FilmBuilder setType(TypeEnum type) {
            this.type = type;
            return this;
        }

        public FilmBuilder setStatus(StatusEnum status) {
            this.status = status;
            return this;
        }

        public FilmBuilder setCountry(UUID country){
            this.country = country;
            return  this;
        }

        public static FilmBuilder create() {
            return new FilmBuilder();
        }


        public FilmRead build() {
            return new FilmRead(uuid, dtCreate, dtUpdate, title,
                    description, dtEvent, dtEndOfSale, type, status, country);
        }


    }


}
