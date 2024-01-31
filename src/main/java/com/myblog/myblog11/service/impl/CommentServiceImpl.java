package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.CommentsDto;
import com.myblog.myblog11.repository.CommentRepository;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentsDto createComments(CommentsDto commentsDto, long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id :" + post_id)
        );
        Comment comment = mapToEntity(commentsDto);
//        Comment comment = new Comment();
//        comment.setEmail(commentsDto.getEmail());
//        comment.setText(commentsDto.getText());
        comment.setPost(post);

        Comment savedComments = commentRepository.save(comment);
//        CommentsDto dto = new CommentsDto();
//
//        dto.setId(savedComments.getId());
//        dto.setEmail(savedComments.getEmail());
//        dto.setText(savedComments.getText());
        return mapToDto(savedComments);
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentsDto updateComments(long id, CommentsDto commentsDto, long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id:" + post_id)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with id:" + id)
        );
        Comment c = mapToEntity(commentsDto);
        c.setId(comment.getId());
        c.setPost(post);
//        comment.setEmail(commentsDto.getEmail());
//        comment.setText(commentsDto.getText());
        Comment update = commentRepository.save(c);
//        CommentsDto dto=new CommentsDto();
//        dto.setId(update.getId());
//        dto.setEmail(update.getEmail());
//        dto.setText(update.getText());
        return mapToDto(update);
    }
    CommentsDto mapToDto(Comment comment){
        CommentsDto dto = modelMapper.map(comment, CommentsDto.class);
        return dto;
    }
    Comment mapToEntity(CommentsDto commentsDto){
        Comment comment = modelMapper.map(commentsDto, Comment.class);
        return comment;
    }
}
