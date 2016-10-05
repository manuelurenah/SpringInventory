package com.cookiebutter.Services;

import com.cookiebutter.Models.UserRoles;
import com.cookiebutter.Repositories.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luis on 04/10/16.
 */
@Service
public class UserRolesService {
    @Autowired
    UserRolesRepository userRolesRepository;

    public UserRoles create(UserRoles userRoles) {
        return userRolesRepository.save(userRoles);
    }
}
