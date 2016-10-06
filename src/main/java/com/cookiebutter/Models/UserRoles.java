package com.cookiebutter.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by luis on 04/10/16.
 */
@Entity
@Table(name="user_roles")
public class UserRoles {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    @Column
    @NotNull
    private String role;

    public long getUserroleid() {
        return id;
    }

    public void setUserroleid(long userroleid) {
        this.id = userroleid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
