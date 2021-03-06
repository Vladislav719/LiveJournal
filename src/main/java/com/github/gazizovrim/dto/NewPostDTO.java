package com.github.gazizovrim.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by vladislav on 12.05.2015.
 */
public class NewPostDTO {

    @NotNull
    private String title;
    @NotNull
    private String message;
    private String tags;

    public NewPostDTO(String title, String message, String tags) {
        this.title = title;
        this.message = message;
        this.tags = tags;
    }

    public NewPostDTO() {
    }

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
