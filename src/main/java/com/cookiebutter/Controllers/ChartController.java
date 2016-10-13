package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Family;
import com.cookiebutter.Services.ArticleService;
import com.cookiebutter.Services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MEUrena on 10/12/16.
 * All rights reserved.
 */

@RestController
public class ChartController {

    @Autowired
    ArticleService articleService;
    @Autowired
    FamilyService familyService;

    @RequestMapping(value = "/chart/general_family", method = RequestMethod.GET)
    public List<Object> renderChart() {
        return articleService.getBorrowedByFamily();
    }

    @RequestMapping(value = "/chart/family_specific", method = RequestMethod.GET)
    public List<Object> renderSpecificChart(@RequestParam("parent_id") long parentId) {
        Family f = familyService.getById(parentId);
        return articleService.getBorrowedByParentFamily(f);
    }

}
