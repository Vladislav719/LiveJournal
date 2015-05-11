package com.github.gazizovrim.model;

import com.github.gazizovrim.model.enums.UserRole;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by vladislav on 10.05.2015.
 */
@Table(name = "USERS")
@Entity
public class User extends BaseEntity{


    private String password;

    @Column(name = "real_name")
    private String login;

    @OneToMany
    private Set<Post> posts;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "user_id")
        @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public Date getCreated() {
        return super.getCreated();
    }

    @Override
    public Date getLastModified() {
        return super.getLastModified();
    }

    @Override
    public void setLastModified(Date lastModified) {
        super.setLastModified(lastModified);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
