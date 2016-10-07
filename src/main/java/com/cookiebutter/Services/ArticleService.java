package com.cookiebutter.Services;

import com.cookiebutter.Models.Article;
import com.cookiebutter.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MEUrena on 10/5/16.
 * All rights reserved.
 */

@Service
@Transactional
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public boolean exists(String name) {
        Article article = articleRepository.findByName(name);
        return article != null;
    }

    public Article create(Article article) {
        return articleRepository.save(article);
    }

    public void delete(Long id) {
        articleRepository.delete(id);
    }

    public List<Article> listAll() {
        return (List<Article>) articleRepository.findAll();
    }

    public long articleCount() {
        return articleRepository.count();
    }

}
