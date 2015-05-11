package com.github.gazizovrim.util;

import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.model.enums.UserRole;

/**
 * Created by vladislav on 10.05.2015.
 */
public final class FormMapper {

    public static User userDtoToUser(UserRegistrationDTO userDto) {
        User user = new User();
        user.setLogin(userDto.getUserName());
        user.setRole(UserRole.USER);
        user.setPassword(userDto.getPassword());
        return user;
    }
}
