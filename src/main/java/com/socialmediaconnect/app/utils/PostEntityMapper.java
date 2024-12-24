package com.socialmediaconnect.app.utils;

import com.socialmediaconnect.app.dto.PostDto;
import com.socialmediaconnect.app.entity.PostEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PostEntityMapper {
    //postEntity to PostDto
    public PostDto mapPostEntityToPostDto(PostEntity postEntity) {
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setTitle(postEntity.getTitle());
        postDto.setDiscription(postEntity.getDescription());
        postDto.setContent(postEntity.getContent());
        return postDto;
    }

    //PostDto to entity
    public PostEntity mapPostDtoToPostEntity(PostDto postDto) {

        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setTitle(postDto.getTitle());
        postEntity.setDescription(postDto.getDiscription());
        postEntity.setContent(postDto.getContent());
        return postEntity;
    }

}
