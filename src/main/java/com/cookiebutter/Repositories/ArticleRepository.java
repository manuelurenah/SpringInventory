package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Article;
import com.cookiebutter.Models.Family;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Objects;

/**
 * Created by MEUrena on 10/5/16.
 * All rights reserved.
 */
public interface ArticleRepository extends DataTablesRepository<Article, Long> {
    Article findByName(String name);
    Article findById(long id);
    @Query("SELECT parent.name as name, sum(b.quantity) as totalArticlesBorrowed from Borrowed as b, Family as f, Family as parent, Article as a WHERE\n" +
            "b.article = a AND a.family = f AND f.parent= parent GROUP BY parent.id")
    List<Object> getBorrowedByFamily();
    @Query("SELECT f.name as name, sum(b.quantity) as totalArticlesBorrowed from Family as f, Borrowed as b, Article as a where \n" +
            "b.article = a AND a.family = f AND f.parent = ?1 GROUP BY f.id")
    List<Object> getBorrowedByParentFamily(Family family);
}
