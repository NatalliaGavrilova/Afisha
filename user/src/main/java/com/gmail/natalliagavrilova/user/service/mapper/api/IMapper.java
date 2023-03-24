package com.gmail.natalliagavrilova.user.service.mapper.api;

import com.gmail.natalliagavrilova.user.dao.entity.User;
import com.gmail.natalliagavrilova.user.dto.UserCreate;
import com.gmail.natalliagavrilova.user.dto.UserRead;
import com.gmail.natalliagavrilova.user.dto.UserRegistration;
import com.gmail.natalliagavrilova.user.dto.UserUpdate;
import com.gmail.natalliagavrilova.user.page.PageRead;
import org.springframework.data.domain.Page;

public interface IMapper {
    User mapAdminCreate(UserCreate dto);
    User mapUserCreateWithoutRole(UserRegistration dto);
    UserRead mapRead(User user);
    PageRead<UserRead> mapPage(Page<User> page);
    User mapUpdate(UserUpdate dto);


}
