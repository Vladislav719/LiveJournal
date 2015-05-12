package com.github.gazizovrim.service.impl;

import com.github.gazizovrim.dto.TagDTO;
import com.github.gazizovrim.model.Tag;
import com.github.gazizovrim.repository.TagRepository;
import com.github.gazizovrim.service.TagService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladislav on 12.05.2015.
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> tagList() {
        return Lists.newArrayList(tagRepository.findAll());
    }

    @Override
    public Tag addNewTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setTagTitle(tagDTO.getTitle());
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> saveTagsList(Iterable<Tag> tags) {
        return Lists.newArrayList(tagRepository.save(tags));
    }
}
