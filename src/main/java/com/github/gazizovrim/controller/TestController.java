package com.github.gazizovrim.controller;

import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.model.enums.UserRole;
import com.github.gazizovrim.repository.UserRepository;
import com.github.gazizovrim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladislav on 11.05.2015.
 */@Controller
@RequestMapping
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void testRepo() {
        User suer = userRepository.findByLogin("Vladislav");
        System.out.println(suer);
        suer.setRole(UserRole.ADMIN);
        userRepository.save(suer);
        int i = 1+1;
        System.out.println(((int) (i + System.nanoTime())));
        userRepository.findByLogin("vladislav");
        User user  = userService.getUserById(1l);
        if (user == null)
            System.out.println("kol");
    }

}
