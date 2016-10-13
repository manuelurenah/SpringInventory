package com.cookiebutter.Controllers;

import com.cookiebutter.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/chart/general_family", method = RequestMethod.GET)
    public List<Object> renderChart() {
        return articleService.getBorrowedByFamily();
    }

}
