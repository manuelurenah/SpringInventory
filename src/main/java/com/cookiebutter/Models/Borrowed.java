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
@Table(name = "borrowed")
public class Borrowed {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User client;
    @ManyToOne
    private Article article;
    @Column
    private int quantity; //How many items of article were taken.
    @Column
    @DateTimeFormat
    private Date takenOn;
    @Column
    @DateTimeFormat
    private Date returnDate;

    public Borrowed() {}

    public Borrowed(Borrowed borrowed) {
        this.client = borrowed.client;
        this.article = borrowed.article;
        this.quantity = borrowed.quantity;
        this.takenOn = borrowed.takenOn;
        this.returnDate = borrowed.returnDate;
    }

    public Borrowed(User client, Article article, int quantity, Date takenOn, Date returnDate) {
        this.client = client;
        this.article = article;
        this.quantity = quantity;
        this.takenOn = takenOn;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTakenOn() {
        return takenOn;
    }

    public void setTakenOn(Date takenOn) {
        this.takenOn = takenOn;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
