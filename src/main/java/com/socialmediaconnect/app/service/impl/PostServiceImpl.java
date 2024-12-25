package com.socialmediaconnect.app.service.impl;

import com.socialmediaconnect.app.dto.PostDto;
import com.socialmediaconnect.app.entity.PostEntity;
import com.socialmediaconnect.app.exceptions.ResourceNotFoundException;
import com.socialmediaconnect.app.repository.PostRepository;
import com.socialmediaconnect.app.service.PostServices;
import com.socialmediaconnect.app.utils.PostEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostServices {

    //private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

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
    public PostDto updatePost(PostDto postDto, long postIdToBeUpdated) {
        // first need to find the post by Id
        // we need postDto but we can get postEntity from the repository So,
        PostEntity postEntityToBeUpdated = this.postRepository.findById(postIdToBeUpdated)
                .orElseThrow(() -> new RuntimeException("Post not found " + postIdToBeUpdated));

            // map PostDto to return postEntity from repository which is here postEntityToBeUpdated for postId
        postEntityToBeUpdated.setTitle(postDto.getTitle());
        postEntityToBeUpdated.setDescription(postDto.getDiscription());
        postEntityToBeUpdated.setContent(postDto.getContent());
        // Now
        // save postEntityToBeUpdated to repository

       PostEntity postEntityUpdated  = this.postRepository.save(postEntityToBeUpdated);

            // map postEntityUpdated to postSto

        return  this.postEntityMapper.mapPostEntityToPostDto(postEntityUpdated);

    }

    @Override
    public boolean deletePostByID(long idToBeDeleted) {
        try {
           PostEntity PostEntityIdFormDB =  this.postRepository.findById(idToBeDeleted).orElseThrow(() ->new ResourceNotFoundException( "Error while getting the post to delete"+idToBeDeleted));
            this.postRepository.delete(PostEntityIdFormDB);
        }catch (Exception e){
            LOGGER.error("Exception while deleting the post by id/idToBeDeleted not found" + idToBeDeleted);
            return false;
        }
        return true;
    }
}
