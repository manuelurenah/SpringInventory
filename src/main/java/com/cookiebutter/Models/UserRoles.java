package com.cookiebutter.Models;

import javax.persistence.*;

/**
 * Created by luis on 04/10/16.
 */
@Entity
@Table(name="user_roles")
public class UserRoles {
    @Id
    @GeneratedValue
    @Column(name="user_role_id")
    private long userroleid;
    @ManyToOne()
    private User user;
    @Column
    private String role;

    public long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(long userroleid) {
        this.userroleid = userroleid;
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
