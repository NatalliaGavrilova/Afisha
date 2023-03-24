package com.gmail.natalliagavrilova.user.service.api;

import com.gmail.natalliagavrilova.user.dao.entity.User;
import com.gmail.natalliagavrilova.user.dto.UserCreate;
import com.gmail.natalliagavrilova.user.dto.UserUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IAdminService {
    User create (UserCreate dto);
    User getOneRaw(UUID uuid);
    Page<User> getUserPage(Pageable pageable);
    void update(UUID uuid, UserUpdate dto, LocalDateTime dtUpdate);
}
