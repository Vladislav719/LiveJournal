package com.github.gazizovrim.util;

import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.exceptions.GeneralException;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.model.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * Created by vladislav on 10.05.2015.
 */
public final class FormMapper {

    public static User userDtoToUser(UserRegistrationDTO userDto) {
        User user = new User();
        user.setRealName(user.getRealName());
        user.setRole(UserRole.USER);
        user.setPassword(userDto.getPassword());
        return user;
    }
}
