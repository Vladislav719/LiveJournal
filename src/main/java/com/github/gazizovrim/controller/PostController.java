package com.github.gazizovrim.controller;

import com.github.gazizovrim.dto.NewPostDTO;
import com.github.gazizovrim.model.Post;
import com.github.gazizovrim.model.Tag;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.service.PostService;
import com.github.gazizovrim.service.TagService;
import com.github.gazizovrim.service.UserService;
import com.github.gazizovrim.util.FormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by vladislav on 12.05.2015.
 */
@Controller
@RequestMapping("/app/")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET, value = "post")
    public String renderPostAddingPage(Model model) {
        model.addAttribute("page", "addPost");
        return "index";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String addPost(Model model, NewPostDTO postDTO,Principal principal) {
//        model.addAttribute("page", "addPost");
        String username = principal.getName();
        User user = userService.findUserByName(username);
        Post post = FormMapper.postDtoToPost(postDTO, user);
        if (!postDTO.getTags().equals("")){
            List<Tag> tags = tagService.saveTagsList(FormMapper.stringToListObject(postDTO.getTags()));
            post.setTags(new HashSet<Tag>(tags));
        }
        postService.createPost(post);
        return "index";
    }
}
