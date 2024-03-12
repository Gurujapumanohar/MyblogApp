package com.example.Myblog.controller;
import com.example.Myblog.payload.PostDto;
import com.example.Myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/post")
public class Postcontroller {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        PostDto dto = postService.savePost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

  @DeleteMapping("/{id}")
   public ResponseEntity<String> deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted",HttpStatus.OK);
   }


   @PutMapping("/{id}")
   public ResponseEntity<PostDto> updatePost(@PathVariable("id") long id,@RequestBody PostDto postDto){
        PostDto dto = postService.updatePost(id,postDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
   };

    @GetMapping
   public List<PostDto> getPosts(){
       List<PostDto> postDtos = postService.getPosts();
       return  postDtos;
   }


}
