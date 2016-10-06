package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Article;
import com.cookiebutter.Models.User;
import com.cookiebutter.Repositories.ArticleRepository;
import com.cookiebutter.Services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by MEUrena on 10/6/16.
 * All rights reserved.
 */

@RestController
public class DataTableController {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    UserService userService;

    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data/articles", method = RequestMethod.GET)
    public DataTablesOutput<Article> getArticles(@Valid DataTablesInput input) {
        return articleRepository.findAll(input);
    }

    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data/users", method = RequestMethod.GET)
    public DataTablesOutput<User> getUsers(@Valid DataTablesInput input) {
        return userService.findAllDT(input);
    }

}
