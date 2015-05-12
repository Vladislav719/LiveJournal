package com.github.gazizovrim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladislav on 12.05.2015.
 */
@Controller
@RequestMapping("/app/")
public class PostController {

    @RequestMapping(method = RequestMethod.GET, value = "post")
    public String renderPostAddingPage(Model model) {
        model.addAttribute("page", "post");
        return "index";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String addPost(Model model) {
        model.addAttribute("page", "addPost");

        return "index";
    }
}
