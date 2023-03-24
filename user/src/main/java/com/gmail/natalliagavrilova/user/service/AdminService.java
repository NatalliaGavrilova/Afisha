package com.gmail.natalliagavrilova.user.service;

import com.gmail.natalliagavrilova.user.dao.api.IRoleDao;
import com.gmail.natalliagavrilova.user.dao.api.IUserDao;
import com.gmail.natalliagavrilova.user.dao.entity.Role;
import com.gmail.natalliagavrilova.user.dao.entity.User;
import com.gmail.natalliagavrilova.user.dto.UserCreate;
import com.gmail.natalliagavrilova.user.dto.UserUpdate;
import com.gmail.natalliagavrilova.user.exceptions.InvalidVersionException;
import com.gmail.natalliagavrilova.user.exceptions.UserNotFoundException;
import com.gmail.natalliagavrilova.user.service.api.IAdminService;
import com.gmail.natalliagavrilova.user.service.mapper.api.IMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import java.util.*;


@Service
@Transactional(readOnly = true)
public class AdminService implements IAdminService {

    private final IUserDao userDao;
    private final IMapper mapper;
    private final IRoleDao roleDao;
    private final PasswordEncoder encoder;

    public AdminService(IUserDao userDao, IMapper mapper, IRoleDao roleDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.mapper = mapper;
        this.roleDao = roleDao;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public User create(UserCreate dto) {
        User user = mapper.mapAdminCreate(dto);

        return this.userDao.save(user);
    }


    @Override
    public User getOneRaw(UUID uuid) {

        return this.userDao
                .findById(uuid)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });
    }

    @Override
    public Page<User> getUserPage(Pageable pageable) {
        return this.userDao.findAll(pageable);
    }


    @Override
    @Transactional
    public void update(UUID uuid, UserUpdate dto, LocalDateTime dtUpdate) {

        User userFromDB = getOneRaw(uuid);

        if (!userFromDB.getDtUpdate().isEqual(dtUpdate)) {
            throw new InvalidVersionException();
        }

        User user = mapper.mapUpdate(dto);

        user.setUuid(userFromDB.getUuid());
        user.setDtUpdate(dtUpdate);
        user.setDtCreate(userFromDB.getDtCreate());
        user.setPassword(userFromDB.getPassword());

        Role role_user = roleDao.findByName("ROLE_USER");
        user.setRole(List.of(role_user));

        userDao.save(user);

    }


}
