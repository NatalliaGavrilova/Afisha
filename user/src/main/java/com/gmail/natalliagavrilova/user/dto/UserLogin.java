package com.gmail.natalliagavrilova.user.dto;

import javax.validation.constraints.Email;

public class UserLogin {


    private String mail;
    private String password;

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
}
