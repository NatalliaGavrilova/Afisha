package com.gmail.natalliagavrilova.user.dao.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "users_service", name = "users")
public class User implements UserDetails {

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    @Version
    private LocalDateTime dtUpdate;
    @Id
    private UUID uuid;
    @Column(name = "mail")
    private String mail;
    private String nick;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "users_service", name = "cross_roles",
            joinColumns = { @JoinColumn(name = "user_mail", referencedColumnName = "mail")},
            inverseJoinColumns = { @JoinColumn(name = "id_role", referencedColumnName = "id")})
    private List<Role> role;
    @Column(name = "status")
    private String status;
    private String password;


    public User() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Role> getRole() {
        return role;
    }

    public List<String> getStringRole(){

        List<String> roleList = new ArrayList<>();

        for (Role role : getRole()) {
            roleList.add(role.getName());
        }
        return roleList;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}




