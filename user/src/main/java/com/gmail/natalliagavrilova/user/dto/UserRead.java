package com.gmail.natalliagavrilova.user.dto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gmail.natalliagavrilova.user.controller.utils.json.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class UserRead {

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtCreate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtUpdate;
    private UUID uuid;

    private String mail;
    private String nick;
    private List<String> role;
    private String status;

    public UserRead() {
    }

    public UserRead(LocalDateTime dtCreate, LocalDateTime dtUpdate,
                    UUID uuid, String mail, String nick, List<String> role, String status) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
        this.mail = mail;
        this.nick = nick;
        this.role = role;
        this.status = status;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}