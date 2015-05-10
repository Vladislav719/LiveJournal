package com.github.gazizovrim.security.impl;

import com.github.gazizovrim.model.User;
import com.github.gazizovrim.security.UserSecurityService;
import com.github.gazizovrim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladislav on 30.04.2015.
 */
@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private UserService userService;

    @Override
    public User getUser(String login) {
        return userService.findUserByName(login);
    }
}
