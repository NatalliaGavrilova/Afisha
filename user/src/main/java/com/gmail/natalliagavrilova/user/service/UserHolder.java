package com.gmail.natalliagavrilova.user.service;

import com.gmail.natalliagavrilova.user.dao.entity.User;
import com.gmail.natalliagavrilova.user.dto.UserRead;
import com.gmail.natalliagavrilova.user.service.mapper.api.IMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

    private final IMapper IMapper;

    public UserHolder(IMapper IMapper) {
        this.IMapper = IMapper;
    }

    public UserRead getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return IMapper.mapRead(user);

    }


}
