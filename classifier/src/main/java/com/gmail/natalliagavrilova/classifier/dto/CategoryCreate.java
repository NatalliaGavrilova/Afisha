package com.gmail.natalliagavrilova.classifier.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gmail.natalliagavrilova.classifier.utils.LocalDateTimeDeserializer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CategoryCreate implements Serializable {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dtCreate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dtUpdate;

    private String title;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoryCreate(@JsonProperty(value = "title", required = true)String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
