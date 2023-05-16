package com.ProjectTD.app.ProjectTD.Service;

import com.ProjectTD.app.ProjectTD.Models.Role;
import com.ProjectTD.app.ProjectTD.Models.User;
import com.ProjectTD.app.ProjectTD.Repo.UserRepo;
import com.ProjectTD.app.ProjectTD.Web.DTO.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getUserName(),registrationDTO.getPassword(), Arrays.asList(new Role("ROLE USER")));
        return userRepo.save(user);
    }
}
