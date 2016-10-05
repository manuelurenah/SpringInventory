package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MEUrena on 10/5/16.
 * All rights reserved.
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    Article findByName(String name);
}
