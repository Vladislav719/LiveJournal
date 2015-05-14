package com.github.gazizovrim.controller;

import com.github.gazizovrim.dto.CommentDTO;
import com.github.gazizovrim.model.Comment;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.service.CommentService;
import com.github.gazizovrim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by vladislav on 13.05.2015.
 */
@RequestMapping("/app")
@Controller
public class CommentController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;


    //for ajax requesting only
    @RequestMapping(method = RequestMethod.POST, value = "comment")
    public @ResponseBody
    Comment addComment(@Valid CommentDTO commentDTO, Principal principal) {
        User user = null;
        if (principal != null) {
            String name = principal.getName();

            if (name != null)
                user = userService.findUserByName(name);
        }
        return commentService.addComment(commentDTO, user);
    }


    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public String sendComment(Model model,@Valid CommentDTO commentDTO, Principal principal) {
        User user = null;
        if (principal != null) {
            String name = principal.getName();

            if (name != null)
                user = userService.findUserByName(name);
        }
        commentService.addComment(commentDTO, user);
        model.addAttribute("page", "onePost");
        return "index";
    }

}
