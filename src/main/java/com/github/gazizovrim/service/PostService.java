package com.github.gazizovrim.service;

import com.github.gazizovrim.model.Post;

import java.util.List;

/**
 * Created by vladislav on 12.05.2015.
 */
public interface PostService {

    List<Post> getAll();
    List<Post> getAllAllowedToUser();
    Post createPost(Post post);
    boolean deletePost(Post post);
    Post updatePost(Post post);
    Post getOnePostById(long id);
}
