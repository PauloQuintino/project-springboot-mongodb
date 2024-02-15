package com.quintino.project_springboot_mongo.controllers;

import com.quintino.project_springboot_mongo.domain.User;
import com.quintino.project_springboot_mongo.dto.UserDTO;
import com.quintino.project_springboot_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    //get user by ID

    //post user

    //update user

    //delete user by id

}
