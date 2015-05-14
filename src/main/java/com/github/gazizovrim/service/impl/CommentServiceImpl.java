package com.github.gazizovrim.service.impl;

import com.github.gazizovrim.dto.CommentDTO;
import com.github.gazizovrim.model.Comment;
import com.github.gazizovrim.model.Post;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.repository.CommentRepository;
import com.github.gazizovrim.service.CommentService;
import com.github.gazizovrim.service.PostService;
import com.github.gazizovrim.util.FormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladislav on 13.05.2015.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    @Override
    @Transactional
    public Comment addComment(CommentDTO commentDTO, User user) {
        Post post = postService.getOnePostById(commentDTO.getPostId());
        Comment comment = FormMapper.commentDtoToComment(commentDTO, user, post);
        return commentRepository.save(comment);
    }

    @Override
    public boolean deleteComment(Comment comment) {
        return false;
    }

    @Override
    public Comment editComment(CommentDTO newComment, Comment oldComment) {
        return null;
    }

    @Override
    public List<Comment> listCommentInPost(long postId) {
        return commentRepository.commentsByPostId(postId);
    }
}
