package com.quintino.project_springboot_mongo.services;

import com.quintino.project_springboot_mongo.domain.User;
import com.quintino.project_springboot_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }



}
