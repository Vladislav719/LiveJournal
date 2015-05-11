package com.github.gazizovrim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladislav on 11.05.2015.
 */
@Controller
@RequestMapping("/app")
public class SearchController {

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public String doSearch(Model model/*SearchModel*/) {
        return null;
    }

}
