package com.myblog.myblog11.service;

import com.myblog.myblog11.payload.CommentsDto;

public interface CommentService {
   CommentsDto createComments(CommentsDto commentsDto, long post_id);

    void deleteCommentById(long id);

    CommentsDto updateComments(long id, CommentsDto commentsDto);
}
