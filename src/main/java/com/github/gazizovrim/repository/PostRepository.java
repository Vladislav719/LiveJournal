package com.github.gazizovrim.repository;

import com.github.gazizovrim.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladislav on 10.05.2015.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("from Post p where p.postAccess = 'PROTECTED'")
    List<Post> getAllPostsAllowedToUser();

}
