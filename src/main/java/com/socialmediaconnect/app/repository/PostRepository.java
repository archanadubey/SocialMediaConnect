package com.socialmediaconnect.app.repository;

import com.socialmediaconnect.app.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>{
    List<PostEntity> findAll();

}
