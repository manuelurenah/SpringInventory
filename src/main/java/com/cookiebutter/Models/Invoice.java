package com.cookiebutter.Models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
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
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ArticleInvoice> articleInvoices = new ArrayList<>();

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

    public List<ArticleInvoice> getArticleInvoices() {
        return articleInvoices;
    }

    public void setArticleInvoices(List<ArticleInvoice> articleInvoices) {
        this.articleInvoices = articleInvoices;
    }

    public double getTotal() {
        return articleInvoices.stream().mapToDouble(articleInvoices -> articleInvoices.getQuantity() * articleInvoices.getArticle().getCost() * articleInvoices.getDays()).sum();
    }

    public int countArticles(){
        return articleInvoices.stream().mapToInt(articleInvoices -> articleInvoices.getQuantity()).sum();
    }
}
