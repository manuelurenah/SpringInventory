package com.cookiebutter.Components;

import com.cookiebutter.Models.User;
import com.cookiebutter.Models.UserRoles;
import com.cookiebutter.Repositories.UserRolesRepository;
import com.cookiebutter.Services.UserRolesService;
import com.cookiebutter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luis on 03/10/16.
 */
@Component
public class InitialSetup implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;
    @Autowired
    UserService userService;
    @Autowired
    UserRolesService userRolesService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup) {
            return;
        }

        if(!userService.exists("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setRetypePassword("admin");
            admin.setName("Administrator");
            admin.setLastName("Administrator");
            admin.setEmail("admin@mail.com");
            UserRoles adminRole = new UserRoles();
            adminRole.setRole("ROLE_ADMIN");
            UserRoles userRole = new UserRoles();
            userRole.setRole("ROLE_USER");
            admin.getRoles().add(adminRole);
            admin.getRoles().add(userRole);

            adminRole.setUser(admin);
            userRole.setUser(admin);

            admin = userService.create(admin);
            adminRole = userRolesService.create(adminRole);
            userRole = userRolesService.create(userRole);
        }

        alreadySetup = true;
    }
}
