package com.github.gazizovrim.repository;

import com.github.gazizovrim.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladislav on 10.05.2015.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
