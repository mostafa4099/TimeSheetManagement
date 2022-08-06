package com.mostafa.service;

import com.mostafa.Model.UserModel;
import com.mostafa.entity.EmpType;
import com.mostafa.entity.Role;
import com.mostafa.entity.User;
import com.mostafa.repo.EmpTypeRepo;
import com.mostafa.repo.RoleRepo;
import com.mostafa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private EmpTypeRepo empTypeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void initRoleAndUser() {
        User user = userRepo.findByUserName("admin");

        if (null == user) {
            Role adminRole = new Role();
            adminRole.setRoleName("Admin");
            roleRepo.save(adminRole);

            User adminUser = new User();
            adminUser.setUserName("admin");
            adminUser.setPassword(getEncodedPassword("admin"));
            adminUser.setName("Admin");
            adminUser.setRole(adminRole);
            userRepo.save(adminUser);
        }
    }

    @Override
    public UserModel registerNewUser(UserModel model) {
        User user = new User();

        if(null != model.getId()){
            user = userRepo.findById(model.getId()).get();
        }

        user = user.SetUser(model);

        EmpType empType = empTypeRepo.findByTypeCode(model.getEmpTypeCode());

        user.setEmpType(empType);

        if(null != model.getPassword()){
            user.setPassword(getEncodedPassword(model.getPassword()));
        }

        Role role = roleRepo.findByRoleName(model.getRoleName());
        user.setRole(role);

        user = userRepo.save(user);

        if (null != user) {
            model = model.setUserModel(user);
        }

        return model;
    }

    @Override
    public List<UserModel> userList() {
        List<UserModel> userModelList = new ArrayList<>();

        List<User> userList = userRepo.findAll();

        if(userList.size()>0){
            for(User user : userList){
                UserModel model = new UserModel();
                model.setUserModel(user);
                userModelList.add(model);
            }
        }

        return userModelList;
    }

    @Override
    public UserModel getUserById(Long id) {
        UserModel model = new UserModel();
        User user = userRepo.findById(id).get();
        model.setUserModel(user);
        return model;
    }

    @Override
    public String removeUser(Long id) {
        User user = userRepo.findById(id).get();

        userRepo.delete(user);
        return "Success";
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
