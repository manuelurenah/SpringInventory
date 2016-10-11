package com.cookiebutter.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MEUrena on 10/10/16.
 * All rights reserved.
 */

@Entity
@Table(name = "family")
public class Family implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column
    @Size(min = 3, max = 25)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Family parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Family> subfamilies = new ArrayList<>();

    @OneToMany(mappedBy = "family", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    public Family() {
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

    public Family getParent() {
        return parent;
    }

    public void setParent(Family parent) {
        this.parent = parent;
    }

    public List<Family> getSubfamilies() {
        return subfamilies;
    }

    public void setSubfamilies(List<Family> subfamilies) {
        this.subfamilies = subfamilies;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return name;
    }
}
