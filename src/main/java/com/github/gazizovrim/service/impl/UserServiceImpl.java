package com.github.gazizovrim.service.impl;

import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.repository.UserRepository;
import com.github.gazizovrim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladislav on 10.05.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserRegistrationDTO userDto) {



        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User findUserByName(String name) {
        return null;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
