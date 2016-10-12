package com.cookiebutter.Models;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
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
    @Column
    @NotNull
    private String document = "";
    @Lob
    @Column(name = "pic")
    private byte[] picture;

    @OneToMany(mappedBy = "client")
    private List<Borrowed> borroweds;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Invoice> invoices = new ArrayList<>();


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
        this.document = user.getDocument();
        this.picture = user.getPicture();
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getImage() {
        if(picture == null) {
            return null;
        }
        byte[] imgBytesAsBase64 = Base64.encodeBase64(picture);
        String imgDataAsBase64 = new String(imgBytesAsBase64);
        return "data:image/png;base64," + imgDataAsBase64;
    }

    public List<Borrowed> getBorroweds() {
        return borroweds;
    }

    public void setBorroweds(List<Borrowed> borroweds) {
        this.borroweds = borroweds;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
