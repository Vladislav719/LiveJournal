package com.github.gazizovrim.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by vladislav on 10.05.2015.
 */
@Entity
@Table(name = "POSTS")
public class Post extends BaseEntity{

    private String title;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany(mappedBy = "post")
    private List<PostTag> postTagList;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "post_id")
    @Override
    public void setId(Long id) {
        super.setId(id);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<PostTag> getPostTagList() {
        return postTagList;
    }

    public void setPostTagList(List<PostTag> postTagList) {
        this.postTagList = postTagList;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
