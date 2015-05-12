package com.github.gazizovrim.controller;

import com.github.gazizovrim.dto.TagDTO;
import com.github.gazizovrim.exceptions.GeneralException;
import com.github.gazizovrim.model.Tag;
import com.github.gazizovrim.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 12.05.2015.
 */
@RequestMapping
@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/app/tag", method = RequestMethod.POST)
    public @ResponseBody void addNewTag(TagDTO tagDTO) {
        Tag tag = tagService.addNewTag(tagDTO);
        if (tag==null)
            throw new GeneralException("you cannot add new tag", "tag creation error");
    }

    @RequestMapping(value = "/app/tag/all.json", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<String> getAllTag() {
        List<Tag> tags = tagService.tagList();
        ArrayList<String> tagArr = new ArrayList<>();
        for (Tag tag : tags) {
            tagArr.add(tag.getTagTitle().trim());
        }
        return tagArr;
    }

}
