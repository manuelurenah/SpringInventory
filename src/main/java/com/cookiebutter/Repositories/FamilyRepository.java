package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Family;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MEUrena on 10/10/16.
 * All rights reserved.
 */
public interface FamilyRepository extends CrudRepository<Family, Long> {
    Family findByName(String name);
    List<Family> findAllByParentNull();
    List<Family> findAllByParentId(Long id);
    Family findById(long id);

}
