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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User client;
    @Column
    @DateTimeFormat
    private Date returnDate;
    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Article> articles;

    public Invoice() {
    }

    public Invoice(Date createdAt, User client, Date returnDate) {
        this.createdAt = createdAt;
        this.client = client;
        this.returnDate = returnDate;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
