package com.socialmediaconnect.app.service.impl;

import com.socialmediaconnect.app.dto.PostDto;
import com.socialmediaconnect.app.entity.PostEntity;
import com.socialmediaconnect.app.repository.PostRepository;
import com.socialmediaconnect.app.service.PostServices;
import com.socialmediaconnect.app.utils.PostEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostServices {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostEntityMapper postEntityMapper;
//    @Autowired
//    private PostEntity postEntity;


    @Override
    public List<PostDto> getAllPost() {
        List<PostEntity> postEntities = postRepository.findAll();
        if (postEntities != null) {

            List<PostDto> postDtos = postEntities.stream().map(entityToPost -> postEntityMapper.mapPostEntityToPostDto(entityToPost)).collect(Collectors.toList());

            return postDtos;
        }
        return null;
    }

    @Override
    public PostDto getPostById(long id) {

        Optional<PostEntity> postEntityById = postRepository.findById(id);

        PostDto postDtoId = postEntityById.map(postEntity -> postEntityMapper.mapPostEntityToPostDto(postEntity)).orElseThrow(null);

        return postDtoId;



    }

    @Override
    public PostDto createPost(PostDto postToBeCreated) {

        PostEntity postEntitySave = this.postEntityMapper.mapPostDtoToPostEntity(postToBeCreated);
        PostDto createdPostDto = this.postEntityMapper.mapPostEntityToPostDto(this.postRepository.save(postEntitySave));
        return createdPostDto;
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
