package com.socialmediaconnect.app.controller;


//import org.springframework.web.bind.annotation.GetMapping;
import com.socialmediaconnect.app.dto.PostDto;
import com.socialmediaconnect.app.entity.PostEntity;
import com.socialmediaconnect.app.service.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vi/api/posts")
public class PostController{
    @Autowired
    private PostServices postServices;

    // get All the post
    //vi/api/posts
    @GetMapping("/")
    public List<PostDto> fetchAllPost(){
       return this.postServices.getAllPost();

    }
    //vi/api/posts/{postId}
    @GetMapping("/{postId}")
    public PostDto fetchPostById(@PathVariable long postId){

        return this.postServices.getPostById(postId);
    }

    @PostMapping //vi/api/posts
    public PostDto createPostDto(@RequestBody PostDto postDto){
      return  this.postServices.createPost(postDto);
    }

}
