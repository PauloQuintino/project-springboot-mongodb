package com.quintino.project_springboot_mongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    public CommentDTO(){}

    public CommentDTO(String text, Date date, UserDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    private String text;
    private Date date;
    private UserDTO author;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }
}
