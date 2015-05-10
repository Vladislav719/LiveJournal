package com.github.gazizovrim.controller;

import com.github.gazizovrim.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by vladislav on 10.05.2015.
 */
@Controller
@RequestMapping
public class LoginController {

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(
            @RequestParam(required = false, value = "error") String error,
            Model model
    ) {
        if (error != null)
            model.addAttribute("error", "Invalid username or password");
        User user = null;//todo

        if (user == null)
            return "user";
        else
            return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Model model) {
        return "login";
    }

}
