package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Article;
import com.cookiebutter.Models.Constants;
import com.cookiebutter.Models.Family;
import com.cookiebutter.Services.ArticleService;
import com.cookiebutter.Services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    FamilyService familyService;

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
        model.addAttribute("families", familyService.parentFamilies());

        return Constants.BASE_LAYOUT;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String create(@Valid @ModelAttribute(name = "newArticle") Article article,
                         @Valid BindingResult bindingResult,
                         @RequestParam("subfam_id") long familyId,
                         @RequestParam("profile_pic") MultipartFile pic,
                         Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("template_name", "article/add.ftl");
            return Constants.BASE_LAYOUT;
        }
        else {

            if(!articleService.exists(article.getName())) {
                Family fam = familyService.getById(familyId);
                article.setFamily(fam);
                try {
                    article.setPicture(pic.getBytes());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                article = articleService.create(article);
                fam.getArticles().add(article);
                familyService.create(fam);
                return "redirect:/article/list";
            }
            else {
                model.addAttribute("errors", "Article already exists.");
                model.addAttribute("template_name", "article/add.ftl");
                return Constants.BASE_LAYOUT;
            }
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable String id) {
        Long parseId = Long.parseLong(id);
        articleService.delete(parseId);
        return "redirect:/article/list";
    }
}
