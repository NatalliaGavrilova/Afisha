
package com.gmail.natalliagavrilova.user.controller;


import com.gmail.natalliagavrilova.user.dao.entity.User;
import com.gmail.natalliagavrilova.user.dto.UserCreate;
import com.gmail.natalliagavrilova.user.dto.UserRead;

import com.gmail.natalliagavrilova.user.dto.UserUpdate;
import com.gmail.natalliagavrilova.user.page.PageRead;
import com.gmail.natalliagavrilova.user.service.api.IAdminService;
import com.gmail.natalliagavrilova.user.service.mapper.api.IMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class AdminController {


    private final IAdminService adminService;
    private final IMapper mapper;

    public AdminController(IAdminService adminService, IMapper mapper) {
        this.adminService = adminService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserRead> create(@RequestBody UserCreate dto) {

        return new ResponseEntity<>(mapper.mapRead(adminService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageRead<UserRead>> getUserPage(@RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "20") Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        Page<User> userPage = adminService.getUserPage(pageRequest);
        PageRead<UserRead> userReadPage = mapper.mapPage(userPage);
        return ResponseEntity.ok(userReadPage);

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserRead> read(@PathVariable UUID uuid) {

        User oneRaw = adminService.getOneRaw(uuid);
        UserRead userRead = mapper.mapRead(oneRaw);

        return ResponseEntity.ok(userRead);
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public void update(@PathVariable UUID uuid, @RequestBody UserUpdate dto, @PathVariable Long dt_update) {


        LocalDateTime lastKnowDtUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dt_update), ZoneId.systemDefault());

        adminService.update(uuid, dto, lastKnowDtUpdate);


    }
}
/*
    @PutMapping("/{uuid}/dt_update/{dt_update}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void update(@RequestBody UserCreateDto newUser,
                @PathVariable UUID uuid,
                @PathVariable(name = "dt_update") Long dtUpdate) {

        LocalDateTime version = LongToLocalDateTimeUtil.fromLong(dtUpdate);

        service.update(newUser, uuid, version);
    }
 */