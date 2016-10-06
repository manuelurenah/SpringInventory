package com.cookiebutter.Models;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

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
    @JsonView(DataTablesOutput.View.class)
    private long id;
    @Column
    @NotNull(message = "{user.username_not_empty}")
    @Size(min = 4, message = "{user.username_too_short}")
    @JsonView(DataTablesOutput.View.class)
    private String username;
    @Column
    @NotNull
    @Size(min=5, max=30)
    private String password;
    @Column
    @NotNull
    @Size(min=5, max=30)
    private String name;
    @Column
    @NotNull
    @JsonView(DataTablesOutput.View.class)
    private String email;
    @Column
    @NotNull
    @Size(min=5, max=30)
    private String lastName;
    @Column
    private Date birthDate;
    @Column
    private boolean enabled = true;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserRoles> roles = new ArrayList<UserRoles>();
    @NotNull
    @Size(min=5, max=30)
    private String retypePassword;

    @Column
    private boolean admin = false;


    public User(){};
    public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.admin = user.isAdmin();
        this.roles = user.getRoles();
        this.email = user.getEmail();
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return username;
    }

    public boolean hasRole(String role) {
        return this.roles.stream().filter(ur -> ur.getRole().equals(role)).count() != 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
