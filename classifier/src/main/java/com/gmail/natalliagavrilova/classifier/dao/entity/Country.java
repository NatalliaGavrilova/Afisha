package com.gmail.natalliagavrilova.classifier.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gmail.natalliagavrilova.classifier.adapter.UUIDAdapter;
import com.gmail.natalliagavrilova.classifier.utils.LocalDateTimeSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "country", schema = "classifier")
public class Country {

    @Column(name = "dt_create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtCreate;
    @Version
    @Column(name = "dt_update")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtUpdate;

    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;


    public Country(LocalDateTime dtCreate,
                   LocalDateTime dtUpdate,
                   UUID uuid, String title,
                   String description) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
        this.title = title;
        this.description = description;
    }

    public Country() {
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