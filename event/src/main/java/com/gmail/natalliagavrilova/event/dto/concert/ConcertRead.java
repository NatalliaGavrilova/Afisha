package com.gmail.natalliagavrilova.event.dto.concert;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.gmail.natalliagavrilova.event.dao.entity.StatusEnum;
import com.gmail.natalliagavrilova.event.dao.entity.TypeEnum;
import com.gmail.natalliagavrilova.event.dto.film.FilmRead;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonDeserialize(builder = FilmRead.FilmBuilder.class)
public class ConcertRead {

    private UUID uuid;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtCreate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtUpdate;

    private String title;
    private String description;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtEvent;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtEndOfSale;
    private TypeEnum type;
    private StatusEnum status;
    private UUID category;

    public ConcertRead(UUID uuid, LocalDateTime dtCreate,
                       LocalDateTime dtUpdate, String title, String description,
                       LocalDateTime dtEvent, LocalDateTime dtEndOfSale,
                       TypeEnum type, StatusEnum status,UUID category) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.category = category;
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

    public UUID getCategory() {
        return category;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class ConcertBuilder {

        private UUID uuid;
        private LocalDateTime dtCreate;
        private LocalDateTime dtUpdate;
        private String title;
        private String description;
        private LocalDateTime dtEvent;
        private LocalDateTime dtEndOfSale;
        private TypeEnum type;
        private StatusEnum status;
        private UUID category;

        private ConcertBuilder() {
        }

        public ConcertBuilder setUuid(UUID uuid) {
            this.uuid=uuid;
            return this;
        }

        public ConcertBuilder setDtCreate(LocalDateTime dtCreate) {
            this.dtCreate = dtCreate;
            return this;
        }

        public ConcertBuilder setDtUpdate(LocalDateTime dtUpdate) {
            this.dtUpdate = dtUpdate;
            return this;
        }

        public ConcertBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ConcertBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ConcertBuilder setDtEvent(LocalDateTime dtEvent) {
            this.dtEvent = dtEvent;
            return this;
        }

        public ConcertBuilder setDtEndOfSale(LocalDateTime dtEndOfSale) {
            this.dtEndOfSale = dtEndOfSale;
            return this;
        }

        public ConcertBuilder setType (TypeEnum type) {
            this.type = type;
            return this;
        }

        public ConcertBuilder setStatus(StatusEnum status) {
            this.status = status;
            return this;
        }

        public ConcertBuilder setCategory(UUID category) {
            this.category = category;
            return this;
        }

        public static ConcertBuilder create() {
            return new ConcertBuilder();
        }


        public ConcertRead build() {
            return new ConcertRead(uuid, dtCreate, dtUpdate, title,
                    description, dtEvent, dtEndOfSale, type, status, category);
        }

    }



}
