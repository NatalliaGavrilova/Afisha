package com.gmail.natalliagavrilova.user.service.api;

import com.gmail.natalliagavrilova.user.dto.UserLogin;
import com.gmail.natalliagavrilova.user.dto.UserRead;
import com.gmail.natalliagavrilova.user.dto.UserRegistration;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    void create( UserRegistration dto);

    String login(UserLogin dto);

    UserRead getUserDetails();

}
