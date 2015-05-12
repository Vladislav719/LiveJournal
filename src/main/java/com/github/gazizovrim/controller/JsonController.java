package com.github.gazizovrim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vladislav on 12.05.2015.
 */
@RequestMapping
@Controller
public class JsonController {

    @ResponseBody
    @RequestMapping(value = "/app/tags.json", method = RequestMethod.GET)
    public Object testJson() {

        return null;
    }

}
