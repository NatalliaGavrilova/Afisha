package com.gmail.natalliagavrilova.user.dto;

import com.gmail.natalliagavrilova.user.dao.entity.Role;

import java.util.List;


public class UserUpdate {
    private String nick;
    private String mail;
    private String password;
    private List<Role> role;
    private String Status;

    public UserUpdate() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
