package com.cookiebutter.Models;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

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
    @JsonView(DataTablesOutput.View.class)
    private long id;
    @Column
    @NotNull
    @JsonView(DataTablesOutput.View.class)
    private String name;
    @Column
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Invoice invoice;
    @Lob
    @Column(name = "pic")
    private byte[] picture;

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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
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
}
