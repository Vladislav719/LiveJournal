package com.github.gazizovrim.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vladislav on 10.05.2015.
 */
@Entity
@Table(name = "TAGS")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_title")
    private String tagTitle;

    @OneToMany(mappedBy = "tag")
    private List<PostTag> postTagList;


    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public List<PostTag> getPostTagList() {
        return postTagList;
    }

    public void setPostTagList(List<PostTag> postTagList) {
        this.postTagList = postTagList;
    }
}
