package com.github.gazizovrim.util;

import com.github.gazizovrim.dto.NewPostDTO;
import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.model.Post;
import com.github.gazizovrim.model.Tag;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.model.enums.UserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static Post postDtoToPost(NewPostDTO postDTO, User user) {
        Post post = new Post();
        post.setText(postDTO.getMessage());
        post.setAuthor(user);
        post.setTitle(postDTO.getTitle());
        return post;
    }

    public static List<Tag> stringToListObject(String tagsStr) {
        List<Tag> tags = new ArrayList<>();
        String[] strT = tagsStr.split(",");
        Tag newTag = new Tag();
        for (String tag : strT) {
            newTag.setTagTitle(tag);
            tags.add(newTag);
        }
        return tags;
    }
}
