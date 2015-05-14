package com.github.gazizovrim.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by vladislav on 13.05.2015.
 */
public class CommentDTO {
    @NotNull
    private String text;
    @NotNull
    private Long postId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
