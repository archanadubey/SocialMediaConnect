package com.socialmediaconnect.app.utils;

import com.socialmediaconnect.app.dto.PostDto;
import com.socialmediaconnect.app.entity.PostEntity;

import java.util.List;

public class PostEntityMapper {
    //postEntity to PostDto
    public PostDto mapPostEntityToPostDto(PostEntity postEntity) {
        PostDto postDto = new PostDto();
       postDto.setId(postEntity.getId());
       postDto.setTitle(postEntity.getTitle());
       postDto.setDiscription(postEntity.getDescription());
       postDto.setContent(postEntity.getContent());

    }
    //PostDto to entity
    public PostEntity mapPostDtoToPostEntity(PostDto postDto){

        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setTitle(postDto.getTitle());
        postEntity.setDescription(postDto.getDiscription());
        postDto.setContent(postDto.getContent());
    }

}
