package com.gmail.natalliagavrilova.user.controller;

import com.gmail.natalliagavrilova.user.dto.UserLogin;
import com.gmail.natalliagavrilova.user.dto.UserRead;
import com.gmail.natalliagavrilova.user.dto.UserRegistration;
import com.gmail.natalliagavrilova.user.service.UserHolder;
import com.gmail.natalliagavrilova.user.service.api.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    private final PasswordEncoder encoder;
    private final IUserService service;
    private final UserHolder holder;


    public UserController(PasswordEncoder encoder,
                          IUserService service, UserHolder holder) {
        this.encoder = encoder;
        this.service = service;
        this.holder = holder;
    }

    @PostMapping("/registration")
    public ResponseEntity<Void> create(@RequestBody UserRegistration dto) {
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody UserLogin dto) {

        return ResponseEntity.ok(service.login(dto));
    }

    @RequestMapping(value = "/me")
    public UserRead details(){
        return service.getUserDetails();
    }


}
