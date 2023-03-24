package com.gmail.natalliagavrilova.user.service.mapper;

import com.gmail.natalliagavrilova.user.dao.entity.Role;
import com.gmail.natalliagavrilova.user.dao.entity.User;
import com.gmail.natalliagavrilova.user.dto.UserCreate;
import com.gmail.natalliagavrilova.user.dto.UserRead;

import com.gmail.natalliagavrilova.user.dto.UserRegistration;
import com.gmail.natalliagavrilova.user.dto.UserUpdate;
import com.gmail.natalliagavrilova.user.page.PageRead;
import com.gmail.natalliagavrilova.user.service.mapper.api.IMapper;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

@Service
public class Mapper implements IMapper {

    private static PasswordEncoder encoder;

    public Mapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public User mapUserCreateWithoutRole(UserRegistration dto) {

        User user = new User();

        user.setUuid(UUID.randomUUID());
        user.setDtCreate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        user.setDtUpdate(user.getDtCreate());
        user.setMail(dto.getMail());
        user.setNick(dto.getNick());
        user.setRole(List.of(new Role("ROLE_USER")));
        user.setStatus("WAITING_ACTIVATION");
        user.setPassword((encoder.encode(dto.getPassword())));

        return user;
    }

    @Override  // на создание
    public User mapAdminCreate(UserCreate userCreate) {
        User user = new User();

        user.setDtCreate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        user.setDtUpdate(user.getDtCreate());
        user.setUuid(UUID.randomUUID());
        user.setMail(userCreate.getMail());
        user.setNick(userCreate.getNick());
        user.setRole(List.of(new Role(userCreate.getRole())));
        user.setStatus("ACTIVATED");
        user.setPassword(encoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public UserRead mapRead(User user) {

        UserRead dto = new UserRead();

        dto.setUuid(user.getUuid());
        dto.setDtCreate(user.getDtCreate());
        dto.setDtUpdate(user.getDtUpdate());
        dto.setMail(user.getMail());
        dto.setNick(user.getNick());
        dto.setRole(user.getStringRole());
        dto.setStatus(user.getStatus());

        return dto;
    }


    @Override
    public PageRead<UserRead> mapPage(Page<User> page) {

        PageRead<UserRead> pageDto = new PageRead<>();
        List<UserRead> contentDto = new ArrayList<>();

        for (User user : page.getContent()) {

            contentDto.add(mapRead(user));
        }
        pageDto.setNumber(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setTotalPages(page.getTotalPages());
        pageDto.setFirst(page.isFirst());
        pageDto.setNumberOfElements(page.getNumberOfElements());
        pageDto.setLast(page.isLast());
        pageDto.setContent(contentDto);
        pageDto.setTotalElements(page.getTotalElements());

        return pageDto;
    }

    @Override
    public User mapUpdate(UserUpdate dto) {
        User user = new User();

        user.setMail(dto.getMail());
        user.setNick(dto.getNick());
        user.setStatus("ACTIVATED");


        return user;
    }
}
