package com.example.Myblog.service.impl;

import com.example.Myblog.entity.Post;
import com.example.Myblog.exception.ResourceNotFound;
import com.example.Myblog.payload.PostDto;
import com.example.Myblog.repository.PostRepository;
import com.example.Myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

   private PostRepository postRepository;

    public PostServiceImpl(PostRepository postrepository) {
        this.postRepository = postrepository;
    }

    @Override
    public PostDto savePost(PostDto postDto) {
        Post savedPost=mapToEntity(postDto);
        Post post= postRepository.save(savedPost);
        PostDto dto=mapToDto(savedPost);
        return dto;
    }


    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setTitle(postDto.getContent());
        postDto.setDescription(postDto.getDescription());
        postDto.setContent(postDto.getContent());
        return postDto;

    }

    @Override
    public void deletePost(long id) {
         postRepository.deleteById(id);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("Post not found with id "+id)
        );
        post.setTitle(postDto.getTitle());
        post.setDescription(post.getDescription());
        post.setContent(post.getContent());

        Post updatePost = postRepository.save(post);
        PostDto dto = mapToDto(updatePost);
        return dto;

    }

    @Override
    public List<PostDto> getPosts() {
        List<Post> Posts = postRepository.findAll();
        List<PostDto> postDtos = Posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return postDtos;
    }


}
