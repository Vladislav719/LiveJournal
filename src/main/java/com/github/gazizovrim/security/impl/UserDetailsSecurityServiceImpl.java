package com.github.gazizovrim.security.impl;

import com.github.gazizovrim.model.User;
import com.github.gazizovrim.security.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vladislav on 30.04.2015.
 */
@Service
public class UserDetailsSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UserSecurityService userSecurityService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userSecurityService.getUser(login);

        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(user.getRealName(),
                user.getPassword(), roles);
    }
}
