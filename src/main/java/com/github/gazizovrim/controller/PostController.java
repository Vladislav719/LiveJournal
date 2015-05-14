package com.github.gazizovrim.controller;

import com.github.gazizovrim.dto.NewPostDTO;
import com.github.gazizovrim.model.Post;
import com.github.gazizovrim.model.Tag;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.service.CommentService;
import com.github.gazizovrim.service.PostService;
import com.github.gazizovrim.service.TagService;
import com.github.gazizovrim.service.UserService;
import com.github.gazizovrim.util.FormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private CommentService commentService;

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

    @RequestMapping(method = RequestMethod.GET, value = "/post/{id}")
    public String onePost(Model model,Principal principal, @PathVariable Long id) {
        User user = null;
        if (principal != null) {
            String name = principal.getName();

            if (name != null)
                user = userService.findUserByName(name);

        }
        model.addAttribute("currentUser", (user == null) ? -1 : user);
        model.addAttribute("page", "onePost");
        model.addAttribute("thePost",postService.getOnePostById(id));
        model.addAttribute("comments", commentService.listCommentInPost(id));
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/post/edit")
    public String renderEditPostPage(Model model) {
        model.addAttribute("page", "postEdit");
        return "index";
    }

    @RequestMapping(value = "/post/edit", method = RequestMethod.POST)
    public String postUpdate(Model model, Principal principal, @PathVariable long id, NewPostDTO postDto) {
        model.addAttribute("page", "onePost");
        User user = null;
        if (principal != null) {
            String name = principal.getName();

            if (name != null)
                user = userService.findUserByName(name);

        }
        Post post = postService.getOnePostById(id);
        if (user != null) {
            if (user.getId() == post.getAuthor().getId()) {
                //do all what u want with this fucking model:)
                postService.updatePost(post);
            }
        }
        return "index";
    }
}
