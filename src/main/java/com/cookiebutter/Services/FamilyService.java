package com.cookiebutter.Services;

import com.cookiebutter.Models.Article;
import com.cookiebutter.Models.Family;
import com.cookiebutter.Repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MEUrena on 10/10/16.
 * All rights reserved.
 */

@Service
@Transactional
public class FamilyService {

    @Autowired
    FamilyRepository familyRepository;

    public boolean exists(String name) {
        Family family = familyRepository.findByName(name);
        return family != null;
    }

    public Family create(Family family) {
        return familyRepository.save(family);
    }

    public void delete(Long id) {
        familyRepository.delete(id);
    }

    public List<Family> listAll() {
        return (List<Family>) familyRepository.findAll();
    }

    public long articleCount() {
        return familyRepository.count();
    }

}
