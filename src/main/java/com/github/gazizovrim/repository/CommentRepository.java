package com.github.gazizovrim.repository;

import com.github.gazizovrim.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladislav on 10.05.2015.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query("from Comment c where c.post.id=?1")
    List<Comment> commentsByPostId(long id);
}
