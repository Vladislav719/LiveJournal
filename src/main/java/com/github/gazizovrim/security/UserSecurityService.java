package com.github.gazizovrim.security;


import com.github.gazizovrim.model.User;

/**
 * Created by vladislav on 30.04.2015.
 */
public interface UserSecurityService {

    public User getUser(String login);
}
