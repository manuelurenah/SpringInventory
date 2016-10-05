package com.cookiebutter.Models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by luis on 03/10/16.
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column
    @NotNull
    @Min(4)
    private String username;
    @Column
    @NotNull
    @Size(min=6, max=30)
    private String password;
    @Column
    @NotNull
    @Size(min=6, max=30)
    private String name;
    @Column
    @NotNull
    @Size(min=6, max=30)
    private String lastName;
    @Column
    private Date birthDate;
    @Column
    private boolean enabled;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoles> roles = new ArrayList<>();
    @NotNull
    @Size(min=6, max=30)
    private String retypePassword;


    public User(){};
    public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<UserRoles> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoles> roles) {
        this.roles = roles;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
