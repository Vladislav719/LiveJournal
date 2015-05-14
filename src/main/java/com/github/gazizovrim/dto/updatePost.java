package com.github.gazizovrim.dto;

import com.github.gazizovrim.model.enums.PostAccess;

import javax.validation.constraints.NotNull;

/**
 * Created by vladislav on 14.05.2015.
 */
public class updatePost {
    private String title;
    private String message;
    private PostAccess postAccess;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PostAccess getPostAccess() {
        return postAccess;
    }

    public void setPostAccess(PostAccess postAccess) {
        this.postAccess = postAccess;
    }
}
