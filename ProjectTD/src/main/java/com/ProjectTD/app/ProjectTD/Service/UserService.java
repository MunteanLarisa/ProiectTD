package com.ProjectTD.app.ProjectTD.Service;

import com.ProjectTD.app.ProjectTD.Models.User;
import com.ProjectTD.app.ProjectTD.Web.DTO.UserRegistrationDTO;

public interface UserService {
    User save(UserRegistrationDTO registrationDTO);

}
