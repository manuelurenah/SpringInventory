package com.cookiebutter.Repositories;

import com.cookiebutter.Models.User;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by luis on 03/10/16.
 */
public interface UserRepository extends DataTablesRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
