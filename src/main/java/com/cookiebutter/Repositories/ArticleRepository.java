package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Article;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MEUrena on 10/5/16.
 * All rights reserved.
 */
public interface ArticleRepository extends DataTablesRepository<Article, Long> {
    Article findByName(String name);
    Article findById(long id);
}
