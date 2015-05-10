package com.github.gazizovrim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladislav on 10.05.2015.
 */
@Controller
@RequestMapping
public class MainController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("message", "man");
        return "hello";
    }
}
