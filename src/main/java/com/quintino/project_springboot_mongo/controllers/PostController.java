package com.quintino.project_springboot_mongo.controllers;

import com.quintino.project_springboot_mongo.controllers.utils.URL;
import com.quintino.project_springboot_mongo.domain.Post;
import com.quintino.project_springboot_mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
        title = URL.decodeParam(title);
        List<Post> posts = postService.findByTitle(title);
        return ResponseEntity.ok().body(posts);
    }


}
