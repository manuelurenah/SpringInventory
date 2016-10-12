package com.cookiebutter.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by MEUrena on 10/11/16.
 * All rights reserved.
 */

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue
    private long id;
    @Column
    @DateTimeFormat
    private Date createdAt;
    @ManyToOne
    private User client;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private List<Article> articles;
    @Column
    private float total = 0;

    public Invoice() {
    }

    public Invoice(Date createdAt, User client, Date returnDate) {
        this.createdAt = createdAt;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
