package com.socialmediaconnect.app.service.impl;

import com.socialmediaconnect.app.dto.PostDto;
import com.socialmediaconnect.app.service.PostServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostServices {


    @Override
    public List<PostDto> getAllPost() {
        return null;
    }

    @Override
    public PostDto getPostById(long id) {
        return null;
    }

    @Override
    public PostDto createPost(PostDto postToBeCreated) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postToBeUpdated) {
        return null;
    }

    @Override
    public boolean deletePostByID(long idToBeDeleted) {
        return false;
    }
}
