package com.github.gazizovrim.service;

import com.github.gazizovrim.dto.CommentDTO;
import com.github.gazizovrim.model.Comment;
import com.github.gazizovrim.model.User;

import java.util.List;

/**
 * Created by vladislav on 13.05.2015.
 */

public interface CommentService {

    Comment addComment(CommentDTO commentDTO, User user);
    boolean deleteComment(Comment comment);
    Comment editComment(CommentDTO newComment, Comment oldComment);
    List<Comment> listCommentInPost(long postId);
}
