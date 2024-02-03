package com.myblog.myblog11.controller;

import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {


   private PostService postService;

    public PostController(PostService postService) {
        
        this.postService = postService;
    }
   @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/posts?pageNo=0&pageSize=3&sortBy=title&sortDir=Desc
//    @GetMapping
//    public List<PostDto> getAllPost(
//            @RequestParam(name="pageNo",required = false,defaultValue = "0")int pageNo ,
//           @RequestParam(name="pageSize",required = false,defaultValue = "3")int pageSize,
//            @RequestParam(name="sortBy",required = false,defaultValue = "id")String sortBy,
//            @RequestParam(name="sortDir",required = false,defaultValue = "id")String sortDir
//            ){
//        List<PostDto> dtos= postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
//        return dtos;
//    }
    // http://localhost:8080/api/posts?pageNo=0&pageSize=3&sortBy=title&sortDir=desc
    @GetMapping
    public List<PostDto> getAllPost(
            @RequestParam(name="pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "3")int pageSize,
            @RequestParam(name="sortBy",required = false,defaultValue = "id")String sortBy,
            @RequestParam(name="sortDir",required = false,defaultValue = "asc")String sortDir

    ){
        List<PostDto> dtos = postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
        return dtos;
    }

}
