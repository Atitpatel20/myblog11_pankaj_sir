package com.myblog.myblog11.controller;

import com.myblog.myblog11.payload.CommentsDto;
import com.myblog.myblog11.service.CommentService;
import com.myblog.myblog11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")

    public class CommentsController {
        private CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }
// This constructor is problematic because it doesn't initialize commentService


    // http://localhost:8080/api/comments?post_id=1
    @PostMapping
    public ResponseEntity<CommentsDto> createComments(
            @RequestBody CommentsDto commentsDto,
            @RequestParam long post_id
    ){
        CommentsDto dtos = commentService.createComments(commentsDto, post_id);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/comments/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteComment(@PathVariable long id){
        commentService.deleteCommentById(id);
        return new ResponseEntity<>("Record is deleted!!",HttpStatus.OK);
    }
    // http://localhost:8080/api/comments/3/post/2
    @PutMapping("/{id}/post/{post_id}")
    public ResponseEntity<CommentsDto>updateComment(@PathVariable long id,@RequestBody CommentsDto commentsDto,@PathVariable long post_id){
        CommentsDto dto=commentService.updateComments(id,commentsDto,post_id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
