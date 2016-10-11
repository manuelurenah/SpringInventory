package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Family;
import com.cookiebutter.Services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luis on 11/10/16.
 */
@Controller
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    FamilyService familyService;

    @GetMapping("/subfamilies")
    public @ResponseBody Family  getSubfamilies(@RequestParam("familyId") long id) {
        Family family = familyService.getById(id);
        return family;
    }
}
