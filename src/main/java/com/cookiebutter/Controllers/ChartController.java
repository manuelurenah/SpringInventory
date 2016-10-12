package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Article;
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

    @RequestMapping(value = "/chart/data", method = RequestMethod.POST)
    public List<Article> renderChart() {
        return articleService.listAll();
    }

}
