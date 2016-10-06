package com.cookiebutter.Services;

import com.cookiebutter.Models.CustomUserDetails;
import com.cookiebutter.Models.User;
import com.cookiebutter.Models.UserRoles;
import com.cookiebutter.Repositories.UserRepository;
import com.cookiebutter.Repositories.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by luis on 04/10/16.
 */
@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User does not exist.");
        }
        else {
            return new CustomUserDetails(user);
        }
    }
}
