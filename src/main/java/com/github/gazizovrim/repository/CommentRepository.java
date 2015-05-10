package com.github.gazizovrim.repository;

import com.github.gazizovrim.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladislav on 10.05.2015.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
