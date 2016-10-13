package com.cookiebutter.Models;

import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.hibernate.loader.custom.Return;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by luis on 12/10/16.
 */
@Entity
@Table(name = "returned")
public class Returned {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private int returned;

    @ManyToOne
    private Borrowed borrowed;
    @Column
    @DateTimeFormat
    private Date returnDate;

    private Date takenOn;
    public Returned() {}

    public Returned(int returned, Borrowed borrowed, Date returnDate) {
        this.returned = returned;
        this.borrowed = borrowed;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public Borrowed getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Borrowed borrowed) {
        this.borrowed = borrowed;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getTakenOn() {
        return takenOn;
    }

    public void setTakenOn(Date takenOn) {
        this.takenOn = takenOn;
    }
}
