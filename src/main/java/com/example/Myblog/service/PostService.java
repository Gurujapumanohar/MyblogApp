package com.example.Myblog.service;

import com.example.Myblog.entity.Post;
import com.example.Myblog.payload.PostDto;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public interface PostService {

    PostDto savePost(PostDto postDto);

    void deletePost(long id);

    PostDto updatePost(long id, PostDto postDto);

    List<PostDto> getPosts();
}
