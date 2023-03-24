package com.gmail.natalliagavrilova.user.service;

import com.gmail.natalliagavrilova.user.controller.utils.json.JwtTokenUtil;
import com.gmail.natalliagavrilova.user.dao.api.IRoleDao;
import com.gmail.natalliagavrilova.user.dao.api.IUserDao;

import com.gmail.natalliagavrilova.user.dao.entity.Role;
import com.gmail.natalliagavrilova.user.dao.entity.User;
import com.gmail.natalliagavrilova.user.dto.UserLogin;
import com.gmail.natalliagavrilova.user.dto.UserRead;
import com.gmail.natalliagavrilova.user.dto.UserRegistration;
import com.gmail.natalliagavrilova.user.exceptions.InvalidPasswordException;
import com.gmail.natalliagavrilova.user.exceptions.MailExistException;
import com.gmail.natalliagavrilova.user.exceptions.UserNameNotFoundException;
import com.gmail.natalliagavrilova.user.service.api.IUserService;
import com.gmail.natalliagavrilova.user.service.mapper.api.IMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional(readOnly = true)
@Service
public class UserService implements IUserService {
    private final IUserDao userDao;
    private final IMapper IMapper;
    private final PasswordEncoder encoder;
    private final IRoleDao roleDao;
    private final UserHolder holder;

    public UserService(IUserDao userDao, IMapper IMapper, PasswordEncoder encoder,
                       IRoleDao roleDao, UserHolder holder) {
        this.userDao = userDao;
        this.IMapper = IMapper;
        this.encoder = encoder;
        this.roleDao = roleDao;
        this.holder = holder;
    }

    @Override
    @Transactional
    public void create(UserRegistration dto) {

        if (userDao.existsByMail(dto.getMail())) {
            throw new MailExistException();
        }

        User user = IMapper.mapUserCreateWithoutRole(dto);
        Role role_user = roleDao.findByName("ROLE_USER");
        user.setRole(List.of(role_user));

        this.userDao.save(user);

    }


    @Override
    public String login(UserLogin dto) {
        UserDetails details = userDao.findByMail(dto.getMail());

        if (details == null || !encoder.matches(dto.getPassword(), details.getPassword())) {
            throw new InvalidPasswordException();
        }
        return JwtTokenUtil.generateAccessToken(details);
    }

    @Override
    public UserRead getUserDetails() {

        return holder.getUser();
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userDao.findByMail(mail);
        if (user == null) {
            try {
                throw new UserNameNotFoundException();
            } catch (UserNameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return user;
    }


}
