package com.gmail.natalliagavrilova.event.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "concert", schema = "event")
public class Concert implements Serializable {


    @Column(name = "dt_create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Version
    private LocalDateTime dtUpdate;

    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "dt_event")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtEvent;
    @Column(name = "dt_end_of_sale")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtEndOfSale;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private UUID category;

    public Concert() {

    }

    public Concert(LocalDateTime dtCreate,
                   LocalDateTime dtUpdate,
                   UUID uuid, String title, String description,
                   LocalDateTime dtEvent, LocalDateTime dtEndOfSale,
                   TypeEnum type, StatusEnum status, UUID category) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.category = category;
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
