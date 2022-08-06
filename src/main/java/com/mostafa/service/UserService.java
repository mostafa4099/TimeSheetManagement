package com.mostafa.service;

import com.mostafa.Model.UserModel;
import com.mostafa.entity.Role;
import com.mostafa.entity.User;
import com.mostafa.repo.RoleRepo;
import com.mostafa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserService {

    public void initRoleAndUser();

    public UserModel registerNewUser(UserModel user);

    List<UserModel> userList();

    UserModel getUserById(Long id);

    String removeUser(Long id);
}
