package com.quintino.project_springboot_mongo.services;

import com.quintino.project_springboot_mongo.domain.Post;
import com.quintino.project_springboot_mongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }


}
