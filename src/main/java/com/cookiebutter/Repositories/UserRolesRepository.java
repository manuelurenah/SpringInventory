package com.cookiebutter.Repositories;

import com.cookiebutter.Models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by luis on 04/10/16.
 */
public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {
}
