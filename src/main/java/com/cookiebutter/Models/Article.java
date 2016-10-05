package com.cookiebutter.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by MEUrena on 10/4/16.
 * All rights reserved.
 */

@Entity
@Table(name = "article")
public class Article implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column
    @NotNull
    private String name;
    @Column
    private String description;
    @Column
    @NotNull
    private int quantity;
    @Column
    @NotNull
    private double cost;

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

    @Override
    public String toString() {
        return name;
    }
}
