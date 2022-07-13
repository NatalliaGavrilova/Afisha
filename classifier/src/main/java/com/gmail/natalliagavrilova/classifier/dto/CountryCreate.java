package com.gmail.natalliagavrilova.classifier.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gmail.natalliagavrilova.classifier.utils.LocalDateTimeDeserializer;
import java.time.LocalDateTime;
import java.util.Objects;


public class CountryCreate{

    private String title;
    private String description;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CountryCreate(@JsonProperty(value = "title", required = true)String title,
                         @JsonProperty(value = "description", required = true)String description) {

        this.title = title;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCreate that = (CountryCreate) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
