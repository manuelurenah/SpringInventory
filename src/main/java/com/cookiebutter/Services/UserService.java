package com.cookiebutter.Services;

import com.cookiebutter.Models.User;
import com.cookiebutter.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luis on 04/10/16.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public boolean exists(String username) {
        User user = userRepository.findByUsername(username);
        return user != null;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User save(User user) { return userRepository.save(user); }
}
