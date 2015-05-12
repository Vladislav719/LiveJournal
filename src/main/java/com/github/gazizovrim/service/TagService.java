package com.github.gazizovrim.service;

import com.github.gazizovrim.dto.TagDTO;
import com.github.gazizovrim.model.Tag;

import java.util.List;

/**
 * Created by vladislav on 12.05.2015.
 */
public interface TagService {

    List<Tag> tagList();

    Tag addNewTag(TagDTO tagDTO);

    List<Tag> saveTagsList(Iterable<Tag> tags);
}
