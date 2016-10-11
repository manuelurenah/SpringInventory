package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Family;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MEUrena on 10/10/16.
 * All rights reserved.
 */
public interface FamilyRepository extends CrudRepository<Family, Long> {
    Family findByName(String name);

}
