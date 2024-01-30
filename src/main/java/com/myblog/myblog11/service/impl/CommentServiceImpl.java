package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.CommentsDto;
import com.myblog.myblog11.repository.CommentRepository;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentsDto createComments(CommentsDto commentsDto, long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id :" + post_id)
        );
        Comment comment = new Comment();
        comment.setEmail(commentsDto.getEmail());
        comment.setText(commentsDto.getText());
        comment.setPost(post);

        Comment savedComments = commentRepository.save(comment);
        CommentsDto dto = new CommentsDto();

        dto.setId(savedComments.getId());
        dto.setEmail(savedComments.getEmail());
        dto.setText(savedComments.getText());
        return dto;
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentsDto updateComments(long id, CommentsDto commentsDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id:" + id)
        );
        comment.setId(commentsDto.getId());
        comment.setEmail(commentsDto.getEmail());
        comment.setText(commentsDto.getText());
        Comment update = commentRepository.save(comment);
        CommentsDto dto=new CommentsDto();
        dto.setId(update.getId());
        dto.setEmail(update.getEmail());
        dto.setText(update.getText());
        return dto;
    }
}
