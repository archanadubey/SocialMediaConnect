package com.socialmediaconnect.app.service;

import com.socialmediaconnect.app.dto.PostDto;

import java.util.List;

public interface PostServices {

    // get All the post
    List<PostDto> getAllPost();

    // getPostById
    PostDto getPostById(long id);


    // create post

    PostDto createPost(PostDto postToBeCreated);

    // update post

    PostDto updatePost(PostDto postToBeUpdated);
    // delete post
    boolean deletePostByID(long idToBeDeleted);
}
