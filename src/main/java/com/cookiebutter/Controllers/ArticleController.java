package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Article;
import com.cookiebutter.Models.Constants;
import com.cookiebutter.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by MEUrena on 10/4/16.
 * All rights reserved.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/list")
    public String articleList(Model model) {
        List<Article> articles = articleService.listAll();
        model.addAttribute("articles", articles);
        model.addAttribute("template_name", "article/list.ftl");

        return Constants.BASE_LAYOUT;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addArticle(@ModelAttribute(name = "newArticle") Article article, Model model) {
        model.addAttribute("template_name", "article/add.ftl");

        return Constants.BASE_LAYOUT;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String create(@Valid @ModelAttribute(name = "newArticle") Article article,
                         @Valid BindingResult bindingResult,
                         Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("template_name", "article/add.ftl");
            return Constants.BASE_LAYOUT;
        }
        else {
            if(!articleService.exists(article.getName())) {
                articleService.create(article);
                return "redirect:/article/list";
            }
            else {
                model.addAttribute("errors", "Article already exists.");
                model.addAttribute("template_name", "article/add.ftl");
                return Constants.BASE_LAYOUT;
            }
        }
    }
}
