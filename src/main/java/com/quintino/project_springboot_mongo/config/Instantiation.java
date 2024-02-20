package com.quintino.project_springboot_mongo.config;

import com.quintino.project_springboot_mongo.domain.Post;
import com.quintino.project_springboot_mongo.domain.User;
import com.quintino.project_springboot_mongo.dto.AuthorDTO;
import com.quintino.project_springboot_mongo.dto.CommentDTO;
import com.quintino.project_springboot_mongo.dto.UserDTO;
import com.quintino.project_springboot_mongo.repository.PostRepository;
import com.quintino.project_springboot_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); //limpa a coleção no MongoDB
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        List<User> users = Arrays.asList(maria, alex, bob);
        userRepository.saveAll(users);

        Post post1 = new Post(null, sdf.parse("28/03/2018"), "Viajando!", "Estou viajanda para São Paulo! Flw!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("30/03/2018"), "Bom dia", "Hoje acordei feliz e já tamo como em SP...", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new UserDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new UserDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new UserDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        List<Post> posts = Arrays.asList(post1, post2);
        postRepository.saveAll(posts);

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
