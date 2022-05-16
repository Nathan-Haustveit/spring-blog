package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    public List <Post> generatePosts(){
        List<Post> allPosts = new ArrayList<>();
        Post post1 = new Post(1,"first post", "this is my first post");
        Post post2 = new Post(2, " second post", "This is my second post");
        Post post3 = new Post(3, "third post", "This is my third post");
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);
        return allPosts;
    }

    @GetMapping
    public String allPosts(Model model){
        List<Post> allPosts = generatePosts();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }


    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        List<Post> allPosts = generatePosts();
        Post post = null;
        for (int i = 0; i < allPosts.size(); i++){
            if (allPosts.get(i).getId() == id){
                post = allPosts.get(i);
            }
        }
        model.addAttribute("post", post);
        return "posts/show";
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
