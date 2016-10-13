package com.cookiebutter.Models;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by MEUrena on 10/4/16.
 * All rights reserved.
 */

@Entity
@Table(name = "article")
public class Article implements Serializable {

    @Id
    @GeneratedValue
    @JsonView(DataTablesOutput.View.class)
    private long id;
    @Column
    @NotNull
    @JsonView(DataTablesOutput.View.class)
    private String name;
    @Column(length = 1500)
    private String description;
    @Column
    @NotNull
    @JsonView(DataTablesOutput.View.class)
    private int quantity;
    @Column
    @NotNull
    @JsonView(DataTablesOutput.View.class)
    private double cost;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonView(DataTablesOutput.View.class)
    private Family family;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ArticleInvoice> articleInvoices;
    @Lob
    @Column(name = "pic")
    private byte[] picture;

    @OneToMany(mappedBy = "article")
    private List<Borrowed> borroweds;

    public Article() {
    }

    public Article(String name, String description, int quantity, double cost) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getImage() {
        byte[] imgBytesAsBase64 = Base64.encodeBase64(picture);
        String imgDataAsBase64 = new String(imgBytesAsBase64);
        return "data:image/png;base64," + imgDataAsBase64;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Borrowed> getBorroweds() {
        return borroweds;
    }

    public void setBorroweds(List<Borrowed> borroweds) {
        this.borroweds = borroweds;
    }


    public List<ArticleInvoice> getArticleInvoices() {
        return articleInvoices;
    }

    public void setArticleInvoices(List<ArticleInvoice> articleInvoices) {
        this.articleInvoices = articleInvoices;
    }

    public int getRemainingQuantity() {
        int alreadyInUse = this.borroweds.stream().mapToInt(Borrowed::getQuantity).sum();
        return quantity-alreadyInUse;
    }
}
