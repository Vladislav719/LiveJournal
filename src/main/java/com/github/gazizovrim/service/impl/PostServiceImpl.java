package com.github.gazizovrim.service.impl;

import com.github.gazizovrim.model.Post;
import com.github.gazizovrim.repository.PostRepository;
import com.github.gazizovrim.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladislav on 12.05.2015.
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public Post createPost(Post post) {

        return     postRepository.save(post);
    }
}
