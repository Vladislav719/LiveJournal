package com.github.gazizovrim.dto;

import com.google.common.base.Objects;

/**
 * Created by vladislav on 12.05.2015.
 */
public class TagDTO {

    private String title;

    public TagDTO(String title) {
        this.title = title;

    }

    public TagDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDTO tagDTO = (TagDTO) o;
        return Objects.equal(title, tagDTO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
