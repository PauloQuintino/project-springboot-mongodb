package com.quintino.project_springboot_mongo.services;

import com.quintino.project_springboot_mongo.domain.Post;
import com.quintino.project_springboot_mongo.repository.PostRepository;
import com.quintino.project_springboot_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado!"));
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }


}
