package com.github.gazizovrim.controller;

import com.github.gazizovrim.model.Post;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.model.enums.PostAccess;
import com.github.gazizovrim.model.enums.UserRole;
import com.github.gazizovrim.service.PostService;
import com.github.gazizovrim.service.UserService;
import com.github.gazizovrim.util.SecurityContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vladislav on 11.05.2015.
 */
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String indexPageRenderer(Model model, Principal principal) {
        User user = null;
        if (principal != null) {
            String name = principal.getName();

            if (name != null)
                user = userService.findUserByName(name);

        }
        model.addAttribute("page", "allPosts");
        model.addAttribute("postsEntries", preProccessing(postService.getAll(), user));
        return "index";
    }

    private List<Post> preProccessing(List<Post> posts, User owner) {
        List<Post> res = new ArrayList<>();
        if (owner != null)
            if (owner.getRole().equals(UserRole.ADMIN))
                return posts;

        if (owner == null) {
            for (Post post : posts) {
                if (post.getPostAccess().equals(PostAccess.OPEN))
                    res.add(post);
            }
        } else
            for (Post post : posts) {
                if (post.getPostAccess().equals(PostAccess.OPEN))
                    res.add(post);
                else if (post.getPostAccess().equals(PostAccess.PROTECTED) && (owner.getRole().equals(UserRole.ADMIN) || owner.getRole().equals(UserRole.USER)))
                    res.add(post);
                else if (post.getPostAccess().equals(PostAccess.SECRET) && post.getAuthor().equals(owner))
                    res.add(post);
            }
        return res;
    }

}
