package com.github.gazizovrim.service.impl;

import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.repository.UserRepository;
import com.github.gazizovrim.service.UserService;
import com.github.gazizovrim.util.FormMapper;
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
        User user = FormMapper.userDtoToUser(userDto);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByLogin(name);
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
