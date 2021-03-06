package com.github.gazizovrim.model;

import com.github.gazizovrim.model.enums.PostAccess;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by vladislav on 10.05.2015.
 */
@Entity
@Table(name = "POSTS")
public class Post extends BaseEntity {

    private String title;
    @Column(length = 10000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

//    @OneToMany(mappedBy = "post")
//    private List<PostTag> postTagList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "POST_TAGS", joinColumns = {
            @JoinColumn(name = "post_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)})
    private Set<Tag> tags;

    @Enumerated(EnumType.STRING)
    private PostAccess postAccess;

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

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

    public PostAccess getPostAccess() {
        return postAccess;
    }

    public void setPostAccess(PostAccess postAccess) {
        this.postAccess = postAccess;
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

//    public List<PostTag> getPostTagList() {
//        return postTagList;
//    }
//
//    public void setPostTagList(List<PostTag> postTagList) {
//        this.postTagList = postTagList;
//    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
