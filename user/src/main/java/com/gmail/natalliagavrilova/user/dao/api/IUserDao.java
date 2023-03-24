package com.gmail.natalliagavrilova.user.dao.api;

import com.gmail.natalliagavrilova.user.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserDao extends JpaRepository<User, UUID> {

    User findByMail(String mail);

    boolean existsByMail(String mail);



}
