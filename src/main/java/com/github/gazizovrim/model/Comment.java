package com.github.gazizovrim.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vladislav on 10.05.2015.
 */
@Table(name = "COMMENTS")
@Entity
public class Comment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; //???? ? ???????? ???????? ???????????

    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;


    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "comment_id")
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
