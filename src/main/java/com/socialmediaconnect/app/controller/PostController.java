package com.socialmediaconnect.app.controller;


import com.socialmediaconnect.app.dto.PostDto;
import com.socialmediaconnect.app.service.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // update post by Id
    //vi/api/posts/{postId}
    @PutMapping("/{postId}")
    public PostDto updatePostDto(@RequestBody PostDto postDtoToUpdated,@PathVariable long postId){

     return   this.postServices.updatePost(postDtoToUpdated, postId);

    }

    // delete post
    //vi/api/posts/{postId}
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable long postId){

       boolean isDeleted = this.postServices.deletePostByID(postId);
       if(isDeleted){
        return   ResponseEntity.ok("Post deleted Successfully "+ postId);

       }else
           return new ResponseEntity<>("Error while deleting the post"+postId,HttpStatus.NOT_FOUND);


    }

}
