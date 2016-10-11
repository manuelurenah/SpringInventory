package com.cookiebutter.Components;

import com.cookiebutter.Models.Family;
import com.cookiebutter.Models.User;
import com.cookiebutter.Models.UserRoles;
import com.cookiebutter.Repositories.UserRolesRepository;
import com.cookiebutter.Services.FamilyService;
import com.cookiebutter.Services.UserRolesService;
import com.cookiebutter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    FamilyService familyService;


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

            populateFamilies();
        }

        alreadySetup = true;
    }

    private void populateFamilies() {

        for (int i = 1; i < 4; i++) {
            Family fam = new Family();
            fam.setName("Family#" + i);
            List<Family> subfams = new ArrayList<>();
            fam = familyService.create(fam);
            for (int j = 0; j < 3; j++) {
                Family subfam = new Family();
                subfam.setName("Fam#" + i + "_Sub#" + j);
                subfam.setParent(fam);

                familyService.create(subfam);

                subfams.add(subfam);

            }
            fam.setSubfamilies(subfams);
            familyService.create(fam);
        }

    }

}
