package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    @ResponseBody
    public String allPosts(){
        return "This is where you would view all the posts";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String showIndividualsPost(@PathVariable long id){
        return "This is where you will see one post with the id " + id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String creatPostForm(){
        return "This is where you will see the form to create a post in the db";
    }

    @PostMapping
    @ResponseBody
    public String createPost(){
        return "This is where the create post form is submitted";
    }
}
