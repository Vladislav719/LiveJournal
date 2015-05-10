package com.github.gazizovrim.service;

import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.model.User;

/**
 * Created by vladislav on 10.05.2015.
 */
public interface UserService {
    User saveUser(UserRegistrationDTO userDto);
    User getUserById(Long id);
    User findUserByName(String name);
    boolean deleteUser(User user);
}
