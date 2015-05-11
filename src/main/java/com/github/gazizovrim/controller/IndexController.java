package com.github.gazizovrim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladislav on 11.05.2015.
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String indexPageRenderer(Model model) {
        return "index";
    }

}
