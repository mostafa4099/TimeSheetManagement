package com.mostafa.controller;

import com.mostafa.Model.UserModel;
import com.mostafa.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/userReg"})
    @PreAuthorize("hasRole('Admin')")
    public UserModel registerNewUser(@RequestBody UserModel user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/userList"})
    @PreAuthorize("hasRole('Admin')")
    public List<UserModel> userList() {
        return userService.userList();
    }

    @GetMapping({"/getUser/{id}"})
    @PreAuthorize("hasRole('Admin')")
    public UserModel registerNewUser(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping({"/removeUser/{id}"})
    @PreAuthorize("hasRole('Admin')")
    public String removeUser(@PathParam("id") Long id) {
        return userService.removeUser(id);
    }
}
